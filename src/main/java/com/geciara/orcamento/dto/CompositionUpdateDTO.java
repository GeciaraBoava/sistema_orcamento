package com.geciara.orcamento.dto;

import com.geciara.orcamento.model.entitys.MaterialComposition;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CompositionUpdateDTO {

    @NotNull
    private Long id;

    private String description;
    private Long typeId;
    private Long unitMeasureId;
    private List<MaterialComposition> materialComposition;

}
