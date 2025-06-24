package com.geciara.orcamento.dto;

import com.geciara.orcamento.model.entitys.MaterialComposition;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CompositionRequestDTO {

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotNull(message = "Tipo é obrigatório")
    private Long typeId;

    @NotNull(message = "Unidade de medida é obrigatório")
    private Long unitMeasureId;

    @NotNull(message = "Material é obrigatório")
    private List<MaterialComposition> materialComposition;

}
