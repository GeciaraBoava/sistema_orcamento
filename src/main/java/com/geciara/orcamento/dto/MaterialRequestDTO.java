package com.geciara.orcamento.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaterialRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String description;

    @NotNull(message = "Tipo de material é obrigatório")
    private Long materialTypeName;

    @NotNull(message = "Unidade de medida é obrigatório")
    private Long unitMeasureName;

    @NotBlank(message = "Preço atual é obrigatório")
    private BigDecimal currentPrice;

}