package com.geciara.orcamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UnitMeasureUpdateRequestDTO {

    private String description;
    private boolean isActive;

}

