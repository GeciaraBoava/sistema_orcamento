package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.CompositionRequestDTO;
import com.geciara.orcamento.dto.CompositionResponseDTO;
import com.geciara.orcamento.dto.CompositionUpdateDTO;
import com.geciara.orcamento.service.CompositionService;
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
public class CompositionController {

    private final CompositionService compositionService;

    public CompositionController(CompositionService compositionService) {
        this.compositionService = compositionService;
    }

    @GetMapping
    public ResponseEntity<List<CompositionResponseDTO>> listAll() {
        return ResponseEntity.ok(compositionService.listAll());
    }

    @Operation(summary = "Buscar item de produto por ID", description = "Recupera um item de produto pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Item de Produto encontrado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Item de Produto não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<CompositionResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(compositionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CompositionResponseDTO> save(@RequestBody @Valid CompositionRequestDTO entity) {
        CompositionResponseDTO savedEntity = compositionService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        compositionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompositionResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CompositionUpdateDTO entity) {
        CompositionResponseDTO updatedEntity = compositionService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }

}