package com.geciara.orcamento.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomerType {
    PUBLIC("Público"),
    CORPORATIVE("Corporativo"),
    PRIVATE("Particular");

    private final String name;

}
