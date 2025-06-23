package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.ProductItemRequestDTO;
import com.geciara.orcamento.dto.ProductItemResponseDTO;
import com.geciara.orcamento.dto.ProductItemUpdateDTO;
import com.geciara.orcamento.service.ProductItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Item de Produtos", description = "Gerenciamento de itens de produtos do sistema")
@RestController
@RequestMapping("/api/productItems")
@Validated
public class ProductItemController {

    private final ProductItemService productItemService;

    public ProductItemController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }

    @GetMapping
    public ResponseEntity<List<ProductItemResponseDTO>> listAll() {
        return ResponseEntity.ok(productItemService.listAll());
    }

    @Operation(summary = "Buscar item de produto por ID", description = "Recupera um item de produto pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Item de Produto encontrado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Item de Produto não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<ProductItemResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productItemService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductItemResponseDTO> save(@RequestBody @Valid ProductItemRequestDTO entity) {
        ProductItemResponseDTO savedEntity = productItemService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productItemService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductItemResponseDTO> update(@PathVariable Long id,@RequestBody @Valid ProductItemUpdateDTO entity) {
        ProductItemResponseDTO updatedEntity = productItemService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }

}