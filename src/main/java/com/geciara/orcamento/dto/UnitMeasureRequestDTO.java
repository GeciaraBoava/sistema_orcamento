package com.geciara.orcamento.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UnitMeasureRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String description;

}