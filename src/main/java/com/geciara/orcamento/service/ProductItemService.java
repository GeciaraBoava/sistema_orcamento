package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.*;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.ProductItemMapper;
import com.geciara.orcamento.model.entitys.*;
import com.geciara.orcamento.repository.ProductItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductItemService {

    private final ProductItemRepository productItemRepository;
    private final ProductItemMapper productItemMapper;
    private final ItemTypeService itemTypeService;
    private final UnitMeasureService unitMeasureService;
    private final MaterialService materialService;


    public ProductItemService(
            ProductItemRepository productItemRepository,
            ProductItemMapper productItemMapper,
            ItemTypeService itemTypeService,
            UnitMeasureService unitMeasureService,
            MaterialService materialService
    ) {
        this.productItemRepository = productItemRepository;
        this.productItemMapper = productItemMapper;
        this.itemTypeService = itemTypeService;
        this.unitMeasureService = unitMeasureService;
        this.materialService = materialService;
    }

    public ProductItemResponseDTO save(ProductItemRequestDTO dto) {
        ItemType type = itemTypeService.findItemtypeById(dto.getTypeId());
        UnitMeasure unit = unitMeasureService.findUnitMeasureById(dto.getUnitMeasureId());
        Material material = materialService.findMaterialById(dto.getMaterialId());

        ProductItem productItem = productItemMapper.toEntity(dto, type, unit, material);
        productItem = productItemRepository.save(productItem);

        return productItemMapper.toResponseDTO(productItem);
    }

    public List<ProductItemResponseDTO> listAll() {
        return productItemRepository.findAll()
                .stream()
                .map(productItemMapper::toResponseDTO)
                .toList();
    }

    public ProductItemResponseDTO findById(Long id) {
        ProductItem productItem = productItemRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return productItemMapper.toResponseDTO(productItem);
    }

    public ProductItem findProductItemById(Long id) {
        return productItemRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
    }

    public ProductItemResponseDTO update(Long id, ProductItemUpdateDTO dto) {
        ProductItem productItem = productItemRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        ProductItem updatedProductItem = productItemMapper.updateFromDTO(dto, productItem);
        productItemRepository.save(updatedProductItem);
        return productItemMapper.toResponseDTO(updatedProductItem);
    }

    public void delete(Long id) {
        if (!productItemRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        productItemRepository.deleteById(id);
    }

}
