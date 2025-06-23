package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.*;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.ItemTypeMapper;
import com.geciara.orcamento.mapper.ProductItemMapper;
import com.geciara.orcamento.mapper.ProductMapper;
import com.geciara.orcamento.model.entitys.*;
import com.geciara.orcamento.repository.ProductItemRepository;
import com.geciara.orcamento.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final MaterialTypeService materialTypeService;
    private final UnitMeasureService unitMeasureService;
    private final ProductItemService productItemService;

    public ProductService(
            ProductRepository productRepository,
            ProductMapper productMapper,
            MaterialTypeService materialTypeService,
            UnitMeasureService unitMeasureService,
            ProductItemService productItemService
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.materialTypeService = materialTypeService;
        this.unitMeasureService = unitMeasureService;
        this.productItemService = productItemService;
    }

    public ProductResponseDTO save(ProductRequestDTO dto) {
        MaterialType materialType = materialTypeService.findMaterialTypeById(dto.getMaterialTypeId());
        UnitMeasure unitMeasure = unitMeasureService.findUnitMeasureById(dto.getUnitMeasureId());
        List<ProductItem> productItemList = dto.getProductItemIds()
                .stream()
                .map(productItemService::findProductItemById)
                .toList();

        Product product = productMapper.toEntity(dto,materialType, unitMeasure, productItemList);
        product = productRepository.save(product);

        return productMapper.toResponseDTO(product);
    }

    public List<ProductResponseDTO> listAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDTO)
                .toList();
    }

    public ProductResponseDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return productMapper.toResponseDTO(product);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
    }

    public ProductResponseDTO update(Long id, ProductUpdateDTO dto) {
        MaterialType materialType = materialTypeService.findMaterialTypeById(dto.getMaterialTypeId());
        UnitMeasure unitMeasure = unitMeasureService.findUnitMeasureById(dto.getUnitMeasureId());
        List<ProductItem> productItemList = dto.getProductItemIds()
                .stream()
                .map(productItemService::findProductItemById)
                .toList();

        Product product = productRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        Product updatedProduct = productMapper.updateFromDTO(dto, product, materialType, unitMeasure, productItemList);
        productRepository.save(updatedProduct);
        return productMapper.toResponseDTO(updatedProduct);
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        productRepository.deleteById(id);
    }

}
