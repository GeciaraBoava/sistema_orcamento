package com.geciara.orcamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MaterialResponseDTO {

    private Long id;
    private String description;
    private String materialTypeDescription;
    private String unitMeasureDescription;
    private BigDecimal currentPrice;
    private boolean isActive;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
}