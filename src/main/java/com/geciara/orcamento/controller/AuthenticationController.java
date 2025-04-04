package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.AuthenticationDTO;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    //criptografa a senha recebida no 'login' e compara com o hash salvo no banco de dados
    @PostMapping("/login")
    public ResponseEntity<AuthenticationDTO> login(@Valid @RequestBody AuthenticationDTO data) {
        //cria o objeto de autenticação ('token')
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        //autenticação - verifica se o 'login' e senha fornecidos estão corretos
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

}
