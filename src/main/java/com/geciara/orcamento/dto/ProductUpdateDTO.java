package com.geciara.orcamento.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ProductUpdateDTO {

    @NotNull
    private Long id;

    private String description;
    private Long materialTypeId;
    private Long unitMeasureId;
    private LocalDate date;
    private LocalDate referenceDate;
    private List<Long> productItemIds;
    private BigDecimal cost;

}
