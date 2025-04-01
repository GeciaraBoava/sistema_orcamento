package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.UnitMeasureRequestDTO;
import com.geciara.orcamento.dto.UnitMeasureResponseDTO;
import com.geciara.orcamento.dto.UnitMeasureUpdateRequestDTO;
import com.geciara.orcamento.service.UnitMeasureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UnitMeasureController {

    private final UnitMeasureService unitMeasureService;

    public UnitMeasureController(UnitMeasureService unitMeasureService) {
        this.unitMeasureService = unitMeasureService;
    }

    @GetMapping
    public ResponseEntity<List<UnitMeasureResponseDTO>> listAll() {
        return ResponseEntity.ok(unitMeasureService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitMeasureResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(unitMeasureService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UnitMeasureResponseDTO> save(@RequestBody UnitMeasureRequestDTO entity) {
        UnitMeasureResponseDTO savedEntity = unitMeasureService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        unitMeasureService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitMeasureResponseDTO> update(@PathVariable Long id, @RequestBody UnitMeasureUpdateRequestDTO entity) {
        UnitMeasureResponseDTO updatedEntity = unitMeasureService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }


}