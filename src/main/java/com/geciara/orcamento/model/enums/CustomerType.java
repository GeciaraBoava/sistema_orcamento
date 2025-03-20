package com.geciara.orcamento.entitys.enums;

public enum CustomerType {
    PUBLIC("Público"),
    CORPORATIVE("Corporativo"),
    PRIVATE("Particular");

    private final String name;

    private CustomerType(String name) { this.name = name; }

    public String getName() { return name; }

}
