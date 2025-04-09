package com.geciara.orcamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UnitMeasureResponseDTO {

    private Long id;
    private String description;
    private boolean isActive;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
}