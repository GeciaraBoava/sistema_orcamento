package com.geciara.orcamento.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class MaterialCompositionUpdateDTO {

    @NotNull
    private Long id;

    private Long materialId;
    private BigDecimal quantity;
}

