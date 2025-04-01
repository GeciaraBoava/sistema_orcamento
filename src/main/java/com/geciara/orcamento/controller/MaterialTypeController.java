package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.MaterialTypeRequestDTO;
import com.geciara.orcamento.dto.MaterialTypeResponseDTO;
import com.geciara.orcamento.dto.MaterialTypeUpdateRequestDTO;
import com.geciara.orcamento.service.MaterialTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material-types")
@Validated
public class MaterialTypeController {

    private final MaterialTypeService materialTypeService;

    public MaterialTypeController(MaterialTypeService materialTypeService) {
        this.materialTypeService = materialTypeService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialTypeResponseDTO>> listAll() {
        return ResponseEntity.ok(materialTypeService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialTypeResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(materialTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MaterialTypeResponseDTO> save(@Valid @RequestBody MaterialTypeRequestDTO entity) {
        MaterialTypeResponseDTO savedEntity = materialTypeService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        materialTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialTypeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody MaterialTypeUpdateRequestDTO entity) {
        MaterialTypeResponseDTO updatedEntity = materialTypeService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }


}
