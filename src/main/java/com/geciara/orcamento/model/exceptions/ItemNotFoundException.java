package com.geciara.orcamento.model.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
        super("Item não encontrado com o id fornecido");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

}
