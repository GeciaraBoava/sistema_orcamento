package com.geciara.orcamento.config;

import com.geciara.orcamento.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    public SecurityFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {

            //encontra o login validado
            var login = tokenService.validateToken(token);

            //encontra o user referente ao login validado
            UserDetails user = userRepository.findByLogin(login);

            //informações necessárias para as validações dos próximos endpoints
            var  authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            //salva o 'token' no contexto da autenticação para que o ‘user’ acesse a suas permissões
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        //chama o próximo filtro
        filterChain.doFilter(request, response);

    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        //padrão nas requisições http - tipo de 'token' "Bearer "
        return authHeader.replace("Bearer ", "");
    }
}
