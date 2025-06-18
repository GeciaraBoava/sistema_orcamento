package com.geciara.orcamento.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaterialRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String description;

    @NotNull(message = "Tipo de material é obrigatório")
    private String materialTypeDescription;

    @NotNull(message = "Unidade de medida é obrigatório")
    private String unitMeasureDescription;

    @NotBlank(message = "Preço atual é obrigatório")
    private BigDecimal currentPrice;

}