package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.UnitMeasureRequestDTO;
import com.geciara.orcamento.dto.UnitMeasureResponseDTO;
import com.geciara.orcamento.dto.UnitMeasureUpdateRequestDTO;
import com.geciara.orcamento.model.entitys.UnitMeasureEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UnitMeasureMapper {

    public UnitMeasureEntity toUnitMeasureEntity(UnitMeasureRequestDTO dto) {

        UnitMeasureEntity unitMeasure = new UnitMeasureEntity();

        unitMeasure.setDescription(dto.getDescription());
        unitMeasure.setActive(true);
        unitMeasure.setRegisteredAt(LocalDateTime.now());

        return unitMeasure;
    }

    public UnitMeasureEntity updateEntityFromDTO(UnitMeasureUpdateRequestDTO dto,
                                                 UnitMeasureEntity unitMeasure) {
        if(dto.getDescription() != null) unitMeasure.setDescription(dto.getDescription());
        if(dto.getIsActive() != null) unitMeasure.setActive(dto.getIsActive());
        unitMeasure.setUpdatedAt(LocalDateTime.now());

        return unitMeasure;
    }

    public UnitMeasureResponseDTO toResponseDTO(UnitMeasureEntity unitMeasure) {
        UnitMeasureResponseDTO dto = new UnitMeasureResponseDTO();

        dto.setId(unitMeasure.getId());
        dto.setDescription(unitMeasure.getDescription());
        dto.setActive(unitMeasure.isActive());
        dto.setCreatedBy(unitMeasure.getCreatedBy());
        dto.setUpdatedBy(unitMeasure.getUpdatedBy());
        dto.setRegisteredAt(unitMeasure.getRegisteredAt());
        dto.setUpdatedAt(unitMeasure.getUpdatedAt());

        return dto;
    }



}