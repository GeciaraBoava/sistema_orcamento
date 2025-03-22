package com.geciara.orcamento.model.enums;

public enum CustomerType {
    PUBLIC("Público"),
    CORPORATIVE("Corporativo"),
    PRIVATE("Particular");

    private final String name;

    private CustomerType(String name) { this.name = name; }

    public String getName() { return name; }

}
