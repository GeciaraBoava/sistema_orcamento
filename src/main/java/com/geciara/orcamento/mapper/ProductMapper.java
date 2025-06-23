package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.*;
import com.geciara.orcamento.model.entitys.ProductItem;
import com.geciara.orcamento.model.entitys.MaterialType;
import com.geciara.orcamento.model.entitys.Product;
import com.geciara.orcamento.model.entitys.UnitMeasure;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Component
public class ProductMapper {

    private final MaterialTypeMapper materialTypeMapper;
    private final UnitMeasureMapper unitMeasureMapper;
    private final ProductItemMapper productItemMapper;

    public ProductMapper(MaterialTypeMapper materialTypeMapper, UnitMeasureMapper unitMeasureMapper, ProductItemMapper productItemMapper) {
        this.materialTypeMapper = materialTypeMapper;
        this.unitMeasureMapper = unitMeasureMapper;
        this.productItemMapper = productItemMapper;
    }

    public Product toEntity(
            ProductRequestDTO dto,
            MaterialType materialType,
            UnitMeasure unitMeasure,
            List<ProductItem> productItemList
    ) {

        if (dto == null) return null;

        Product product = new Product();

        product.setDescription(dto.getDescription());
        product.setMaterialType(materialType);
        product.setUnitMeasure(unitMeasure);
        product.setDate(dto.getDate());
        product.setReferenceDate(dto.getReferenceDate());
        product.setProductItemList(productItemList);
        product.setCost(dto.getCost());

        return product;
    }

    public Product updateFromDTO(
            ProductUpdateDTO dto,
            Product product,
            MaterialType materialType,
            UnitMeasure unitMeasure,
            List<ProductItem> productItemList
    ) {
        if (dto == null) return null;

        product.setDescription(dto.getDescription());
        product.setMaterialType(materialType);
        product.setUnitMeasure(unitMeasure);
        product.setDate(dto.getDate());
        product.setReferenceDate(dto.getReferenceDate());
        product.setProductItemList(productItemList);
        product.setCost(dto.getCost());

        return product;
    }

    public ProductResponseDTO toResponseDTO(Product product) {

        if (product == null) return null;

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setDescription(product.getDescription());
        dto.setMaterialType(materialTypeMapper.toResponseDTO(product.getMaterialType()));
        dto.setUnitMeasure(unitMeasureMapper.toResponseDTO(product.getUnitMeasure()));
        dto.setRegisteredAt(product.getRegisteredAt());
        dto.setUpdatedAt(product.getUpdatedAt());
        dto.setDate(product.getDate());
        dto.setReferenceDate(product.getReferenceDate());
        dto.setProductItemResponseDTOS(
                product.getProductItemList()
                        .stream()
                        .map(productItemMapper::toResponseDTO)
                        .collect(Collectors.toList()));
        dto.setCost(product.getCost());

        return dto;
    }
}
