package com.geciara.orcamento.model.exceptions;

public class InvalidPriceException extends RuntimeException {
    public InvalidPriceException() {
        super("Preço inválido");
    }

    public InvalidPriceException(String message) {
        super(message);
    }
}
