package com.geciara.orcamento.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemTypeUpdateDTO {

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotBlank(message = "Estado é obrigatória")
    private boolean isActive;

}
