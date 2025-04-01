package com.geciara.orcamento.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaterialUpdateRequestDTO {
    
    private String description;
    private String materialTypeDescription;
    private String unitMeasureDescription;
    private BigDecimal currentPrice;
    private Boolean isActive;

}