package com.geciara.orcamento.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String description;
    private MaterialTypeResponseDTO materialType;
    private UnitMeasureResponseDTO unitMeasure;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private LocalDate date;
    private LocalDate referenceDate;
    private List<ProductItemResponseDTO> productItemResponseDTOS;
    private BigDecimal cost;

}
