package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.MaterialRequestDTO;
import com.geciara.orcamento.dto.MaterialResponseDTO;
import com.geciara.orcamento.dto.MaterialUpdateRequestDTO;
import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.model.entitys.MaterialType;
import com.geciara.orcamento.model.entitys.PriceHistory;
import com.geciara.orcamento.model.entitys.UnitMeasure;

import java.time.LocalDateTime;

public class MaterialMapper {
    public static Material toMaterialEntity(MaterialRequestDTO dto) {

        Material material = new Material();
        material.setDescription(dto.getDescription());

        material.setMaterialTypeId(dto.getMaterialTypeId());
        material.setUnitMeasureId(dto.getUnitMeasureId());

        material.setMaterialTypeId(dto.getMaterialTypeName());

        MaterialType materialType = materialTypeMapper.fromId(dto.getTypeId());
        material.setType(materialType);

        UnitMeasure unitMeasure = unitMeasureMapper.fromId(dto.getUnitMeasureId());
        material.setUnitMeasure(unitMeasure);

        material.setCurrentPrice(dto.getCurrentPrice());
        material.setRegisteredAt(LocalDateTime.now());
        material.setActive(true);

        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setMaterialId(material.getId());
        priceHistory.setPrice(material.getCurrentPrice());
        priceHistory.setRegisteredAt(material.getRegisteredAt());
        material.getPriceHistories().add(priceHistory);

        return material;
    }

    public void updateEntityFromDTO(MaterialUpdateRequestDTO dto,
                                    Material material) {
        if(dto.getDescription() != null) material.setDescription(dto.getDescription());
        if(dto.getMaterialTypeId() != null) material.setMaterialTypeId(dto.getMaterialTypeId());
        if(dto.getUnitMeasureId() != null) material.setUnitMeasureId(dto.getUnitMeasureId());
        if(dto.getIsActive() != null) material.setActive(dto.getIsActive());
        material.setUpdatedAt(LocalDateTime.now());

        if(dto.getCurrentPrice() != null) {
            material.setCurrentPrice(dto.getCurrentPrice());

            PriceHistory newPriceHistory = new PriceHistory();
            newPriceHistory.setMaterialId(material.getId());
            newPriceHistory.setPrice(dto.getCurrentPrice());
            newPriceHistory.setRegisteredAt(material.getRegisteredAt());
            material.setRegisteredAt(LocalDateTime.now());

            material.getPriceHistories().add(newPriceHistory);
        }

    }

    public static MaterialResponseDTO toResponseDTO(Material material) {
        MaterialResponseDTO dto = new MaterialResponseDTO();

        dto.setId(material.getId());
        dto.setDescription(material.getDescription());
        dto.setMaterialTypeId(material.getMaterialTypeId());
        dto.setUnitMeasureId(material.getUnitMeasureId());
        dto.setCurrentPrice(material.getCurrentPrice());
        dto.setActive(material.isActive());
        dto.setRegisteredAt(material.getRegisteredAt());
        dto.setUpdatedAt(material.getUpdatedAt());

        return dto;
    }
}