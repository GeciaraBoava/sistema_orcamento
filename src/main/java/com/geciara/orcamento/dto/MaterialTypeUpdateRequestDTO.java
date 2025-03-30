package com.geciara.orcamento.dto;

import lombok.Data;

@Data
public class MaterialTypeUpdateRequestDTO {
    
    private String description;
    private Boolean isActive;
}
