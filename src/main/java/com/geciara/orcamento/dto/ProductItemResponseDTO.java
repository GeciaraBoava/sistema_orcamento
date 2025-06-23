package com.geciara.orcamento.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductItemResponseDTO {

    private Long id;
    private String description;
    private ItemTypeResponseDTO type;
    private UnitMeasureResponseDTO unitMeasure;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private MaterialResponseDTO material;
    private Integer quantity;
    private BigDecimal cost;

}
