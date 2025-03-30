package com.geciara.orcamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MaterialResponseDTO {

    private Long id;
    private String description;
    private Long materialTypeId;
    private Long unitMeasureId;
    private BigDecimal currentPrice;
    private boolean isActive;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;
}