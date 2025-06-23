package com.geciara.orcamento.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemTypeRequestDTO {

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    private Boolean isActive;

}
