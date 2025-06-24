package com.geciara.orcamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //desabilita a proteção contra CSRF por se tratar de uma API REST que usa JWT
                .csrf(AbstractHttpConfigurer::disable)
                //política de criação de sessão no modo stateless (via 'token')
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Público
                        .requestMatchers("/login", "/auth/login", "/img/**", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

                        // Apenas ADMIN
                        .requestMatchers("/config/**", "/admin/**").hasAnyAuthority("ROLE_ADMIN")

                        // Apenas MANAGER e ADMIN
                        .requestMatchers("/api/users/**").hasAnyAuthority("ROLE_MANAGER", "ROLE_ADMIN")

                        // BUDGET, MANAGER e ADMIN → CRUD de orçamentos, produtos, insumos
                        .requestMatchers("/budgets/**", "/products/**", "/items/**", "/materials/**").hasAnyAuthority("ROLE_BUDGET", "ROLE_MANAGER", "ROLE_ADMIN")

                        // COMMERCIAL pode visualizar orçamentos (ex: páginas de consulta/impressão)
                        .requestMatchers(HttpMethod.GET, "/budgets/**", "/products/**").hasAnyAuthority("ROLE_COMMERCIAL", "ROLE_BUDGET", "ROLE_MANAGER", "ROLE_ADMIN")

                        // Demais requisições → autenticadas
                        .anyRequest().authenticated()
                )
                //chama o filtro de sergurança antes da autenticação do username
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
