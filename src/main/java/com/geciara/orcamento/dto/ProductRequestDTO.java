package com.geciara.orcamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ProductRequestDTO {

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotNull(message = "Tipo de material é obrigatório")
    private Long materialTypeId;

    @NotNull(message = "Unidade de medida é obrigatória")
    private Long unitMeasureId;

    @NotNull(message = "Data é obrigatório")
    private LocalDate date;

    @NotNull(message = "Data de referência é obrigatória")
    private LocalDate referenceDate;

    @NotEmpty(message = "Item de orçamento é obrigatório")
    private List<Long> productItemIds;

    @NotNull(message = "Valor de custo é obrigatório")
    private BigDecimal cost;

}
