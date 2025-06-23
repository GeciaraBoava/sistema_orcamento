package com.geciara.orcamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductItemRequestDTO {

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotNull(message = "Tipo é obrigatório")
    private Long typeId;

    @NotNull(message = "Unidade de medida é obrigatório")
    private Long unitMeasureId;

    @NotNull(message = "Material é obrigatório")
    private Long materialId;

    @NotNull(message = "Quantidade é obrigatório")
    private Integer quantity;

    @NotNull(message = "Custo é obrigatório")
    private BigDecimal cost;

}
