package com.geciara.orcamento.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductItemUpdateDTO {

    private String description;
    private Long typeId;
    private Long unitMeasureId;
    private Long materialId;
    private Integer quantity;
    private BigDecimal cost;

}
