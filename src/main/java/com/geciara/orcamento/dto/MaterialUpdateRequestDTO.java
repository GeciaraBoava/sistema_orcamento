package com.geciara.orcamento.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaterialUpdateRequestDTO {
    
    private String description;
    private Long materialTypeId;
    private Long unitMeasureId;
    private BigDecimal currentPrice;
    private Boolean isActive;

}