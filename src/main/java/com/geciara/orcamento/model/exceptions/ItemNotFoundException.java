package com.geciara.orcamento.model.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
        super("Item não encontrado");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

}
