package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.MaterialRequestDTO;
import com.geciara.orcamento.dto.MaterialResponseDTO;
import com.geciara.orcamento.dto.MaterialUpdateRequestDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.model.entitys.MaterialEntity;
import com.geciara.orcamento.model.entitys.MaterialTypeEntity;
import com.geciara.orcamento.model.entitys.PriceHistoryEntity;
import com.geciara.orcamento.model.entitys.UnitMeasureEntity;
import com.geciara.orcamento.repository.MaterialTypeRepository;
import com.geciara.orcamento.repository.UnitMeasureRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MaterialMapper {

    private final MaterialTypeRepository materialTypeRepository;
    private final UnitMeasureRepository unitMeasureRepository;

    public MaterialMapper(MaterialTypeRepository materialTypeRepository,
                          UnitMeasureRepository unitMeasureRepository) {
        this.materialTypeRepository = materialTypeRepository;
        this.unitMeasureRepository = unitMeasureRepository;
    }


    public MaterialEntity toMaterialEntity(MaterialRequestDTO dto) {

        MaterialEntity material = new MaterialEntity();

        material.setDescription(dto.getDescription());
        material.setCurrentPrice(dto.getCurrentPrice());
        material.setRegisteredAt(LocalDateTime.now());
        material.setActive(true);

        MaterialTypeEntity materialType = materialTypeRepository.findByDescription(dto.getMaterialTypeDescription())
                        .orElseThrow(ItemNotFoundException::new);

        material.setMaterialType(materialType);

        UnitMeasureEntity unitMeasure = unitMeasureRepository.findByDescription(dto.getUnitMeasureDescription())
                        .orElseThrow(ItemNotFoundException::new);

        material.setUnitMeasure(unitMeasure);

        PriceHistoryEntity priceHistory = new PriceHistoryEntity();
        priceHistory.setMaterial(material);
        priceHistory.setPrice(material.getCurrentPrice());
        priceHistory.setRegisteredAt(material.getRegisteredAt());
        material.getPriceHistories().add(priceHistory);

        return material;
    }

    public MaterialEntity updateEntityFromDTO(MaterialUpdateRequestDTO dto,
                                              MaterialEntity material) {
        if(dto.getDescription() != null) material.setDescription(dto.getDescription());
        if(dto.getIsActive() != null) material.setActive(dto.getIsActive());
        material.setUpdatedAt(LocalDateTime.now());

        if(dto.getMaterialTypeDescription() != null) {
            MaterialTypeEntity materialType = materialTypeRepository.findByDescription(dto.getMaterialTypeDescription())
                    .orElseThrow(ItemNotFoundException::new);

            material.setMaterialType(materialType);
        }

        if(dto.getUnitMeasureDescription() != null) {

            UnitMeasureEntity unitMeasure = unitMeasureRepository.findByDescription(dto.getUnitMeasureDescription())
                    .orElseThrow(ItemNotFoundException::new);

            material.setUnitMeasure(unitMeasure);
        }

        if(dto.getCurrentPrice() != null) {
            material.setCurrentPrice(dto.getCurrentPrice());

            PriceHistoryEntity newPriceHistory = new PriceHistoryEntity();
            newPriceHistory.setMaterial(material);
            newPriceHistory.setPrice(dto.getCurrentPrice());
            newPriceHistory.setRegisteredAt(material.getRegisteredAt());
            material.setRegisteredAt(LocalDateTime.now());

            material.getPriceHistories().add(newPriceHistory);
        }

        return material;

    }

    public MaterialResponseDTO toResponseDTO(MaterialEntity material) {
        MaterialResponseDTO dto = new MaterialResponseDTO();

        dto.setId(material.getId());
        dto.setDescription(material.getDescription());
        dto.setCurrentPrice(material.getCurrentPrice());
        dto.setActive(material.isActive());
        dto.setCreatedBy(material.getCreatedBy());
        dto.setUpdatedBy(material.getUpdatedBy());
        dto.setRegisteredAt(material.getRegisteredAt());
        dto.setUpdatedAt(material.getUpdatedAt());

        MaterialTypeEntity materialType = material.getMaterialType();
        dto.setMaterialTypeDescription(materialType.getDescription());

        UnitMeasureEntity unitMeasure = material.getUnitMeasure();
        dto.setUnitMeasureDescription(unitMeasure.getDescription());

        return dto;
    }
}