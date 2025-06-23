package com.geciara.orcamento.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Usuário não encontrado com o id fornecido");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}

