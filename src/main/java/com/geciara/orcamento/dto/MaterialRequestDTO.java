package com.geciara.orcamento.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaterialRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String description;

    @NotBlank(message = "Tipo de material é obrigatório")
    private String materialTypeDescription;

    @NotBlank(message = "Unidade de medida é obrigatório")
    private String unitMeasureDescription;

    @NotNull(message = "Preço atual é obrigatório")
    private BigDecimal currentPrice;

}