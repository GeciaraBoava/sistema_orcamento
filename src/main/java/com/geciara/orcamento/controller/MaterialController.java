package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.MaterialRequestDTO;
import com.geciara.orcamento.dto.MaterialResponseDTO;
import com.geciara.orcamento.dto.MaterialUpdateDTO;
import com.geciara.orcamento.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Insumos", description = "Gerenciamento de insumos do sistema")
@RestController
@RequestMapping("/api/materials")
@Validated
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialResponseDTO>> listAll() {
        return ResponseEntity.ok(materialService.listAll());
    }

    @Operation(summary = "Buscar insumo por ID", description = "Recupera um insumo pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Insumo encontrado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Insumo não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<MaterialResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MaterialResponseDTO> save(@RequestBody @Valid MaterialRequestDTO entity) {
        MaterialResponseDTO savedEntity = materialService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        materialService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialResponseDTO> update(@PathVariable Long id,@RequestBody @Valid MaterialUpdateDTO entity) {
        MaterialResponseDTO updatedEntity = materialService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }


}