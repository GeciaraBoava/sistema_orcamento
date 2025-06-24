package com.geciara.orcamento.dto;

import com.geciara.orcamento.model.entitys.MaterialComposition;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CompositionResponseDTO {

    private Long id;
    private String description;
    private ItemTypeResponseDTO type;
    private UnitMeasureResponseDTO unitMeasure;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private List<MaterialComposition> materialComposition;
    private BigDecimal cost;

}
