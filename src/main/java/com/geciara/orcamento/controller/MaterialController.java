package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.MaterialRequestDTO;
import com.geciara.orcamento.dto.MaterialResponseDTO;
import com.geciara.orcamento.dto.MaterialUpdateRequestDTO;
import com.geciara.orcamento.service.MaterialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<MaterialResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MaterialResponseDTO> save(@Valid @RequestBody MaterialRequestDTO entity) {
        MaterialResponseDTO savedEntity = materialService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        materialService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialResponseDTO> update(@PathVariable Long id,@Valid @RequestBody MaterialUpdateRequestDTO entity) {
        MaterialResponseDTO updatedEntity = materialService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }


}