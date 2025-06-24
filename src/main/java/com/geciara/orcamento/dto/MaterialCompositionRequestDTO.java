package com.geciara.orcamento.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class MaterialCompositionRequestDTO {

    @NotNull
    private Long materialId;

    @NotNull
    private BigDecimal quantity;
}

