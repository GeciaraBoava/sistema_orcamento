package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.MaterialTypeRequestDTO;
import com.geciara.orcamento.dto.MaterialTypeResponseDTO;
import com.geciara.orcamento.dto.MaterialTypeUpdateRequestDTO;
import com.geciara.orcamento.model.entitys.MaterialTypeEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MaterialTypeMapper {

    public MaterialTypeEntity toMaterialTypeEntity(MaterialTypeRequestDTO dto) {

        MaterialTypeEntity materialType = new MaterialTypeEntity();

        materialType.setDescription(dto.getDescription());
        materialType.setActive(true);
        materialType.setRegisteredAt(LocalDateTime.now());

        return materialType;
    }

    public MaterialTypeEntity updateEntityFromDTO(MaterialTypeUpdateRequestDTO dto,
                                                  MaterialTypeEntity materialType) {
        if(dto.getDescription() != null) materialType.setDescription(dto.getDescription());
        if(dto.getIsActive() != null) materialType.setActive(dto.getIsActive());
        materialType.setUpdatedAt(LocalDateTime.now());

        return materialType;
    }

    public MaterialTypeResponseDTO toResponseDTO(MaterialTypeEntity materialType) {
        MaterialTypeResponseDTO dto = new MaterialTypeResponseDTO();

        dto.setId(materialType.getId());
        dto.setDescription(materialType.getDescription());
        dto.setActive(materialType.isActive());
        dto.setCreatedBy(materialType.getCreatedBy());
        dto.setUpdatedBy(materialType.getUpdatedBy());
        dto.setRegisteredAt(materialType.getRegisteredAt());
        dto.setUpdatedAt(materialType.getUpdatedAt());

        return dto;
    }



}

