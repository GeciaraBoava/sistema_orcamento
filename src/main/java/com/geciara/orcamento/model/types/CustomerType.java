package com.geciara.orcamento.model.types;

public enum CustomerType {
    PUBLICO ("Público"),
    CORPORATIVO ("Corporativo"),
    PARTICULAR ("Particular");

    private final String name;

    private CustomerType(String name) { this.name = name; }

    public String getName() { return name; }

}
