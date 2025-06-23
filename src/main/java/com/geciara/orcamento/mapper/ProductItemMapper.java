package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.ProductItemRequestDTO;
import com.geciara.orcamento.dto.ProductItemResponseDTO;
import com.geciara.orcamento.dto.ProductItemUpdateDTO;
import com.geciara.orcamento.model.entitys.ProductItem;
import com.geciara.orcamento.model.entitys.ItemType;
import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.model.entitys.UnitMeasure;
import org.springframework.stereotype.Component;

@Component
public class ProductItemMapper {

    private final ItemTypeMapper itemTypeMapper;
    private final UnitMeasureMapper unitMeasureMapper;
    private final MaterialMapper materialMapper;

    public ProductItemMapper(ItemTypeMapper itemTypeMapper,
                             UnitMeasureMapper unitMeasureMapper,
                             MaterialMapper materialMapper) {
        this.itemTypeMapper = itemTypeMapper;
        this.unitMeasureMapper = unitMeasureMapper;
        this.materialMapper = materialMapper;
    }

    public ProductItem toEntity(
            ProductItemRequestDTO dto,
            ItemType itemType,
            UnitMeasure unitMeasure,
            Material material
    ) {
        if (dto == null) return null;

        ProductItem productItem = new ProductItem();
        productItem.setDescription(dto.getDescription());
        productItem.setType(itemType);
        productItem.setUnitMeasure(unitMeasure);
        productItem.setMaterial(material);
        productItem.setQuantity(dto.getQuantity());
        productItem.setCost(dto.getCost());

        return productItem;
    }

    public ProductItem updateFromDTO(
            ProductItemUpdateDTO dto,
            ProductItem productItem
    ) {

        if (dto == null) return null;

        productItem.setDescription(dto.getDescription());
        productItem.setCost(dto.getCost());

        return productItem;
    }

    public ProductItemResponseDTO toResponseDTO(ProductItem productItem) {

        if (productItem == null) return null;

        ProductItemResponseDTO dto = new ProductItemResponseDTO();

        dto.setId(productItem.getId());
        dto.setDescription(productItem.getDescription());
        dto.setType(itemTypeMapper.toResponseDTO(productItem.getType()));
        dto.setUnitMeasure(unitMeasureMapper.toResponseDTO(productItem.getUnitMeasure()));
        dto.setRegisteredAt(productItem.getRegisteredAt());
        dto.setUpdatedAt(productItem.getUpdatedAt());
        dto.setMaterial(materialMapper.toResponseDTO(productItem.getMaterial()));
        dto.setQuantity(productItem.getQuantity());
        dto.setCost(productItem.getCost());

        return dto;
    }

}
