package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.SupplierRequestDTO;
import com.geciara.orcamento.dto.SupplierResponseDTO;
import com.geciara.orcamento.dto.SupplierUpdateRequestDTO;
import com.geciara.orcamento.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Validated
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDTO>> listAll() {
        return ResponseEntity.ok(supplierService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SupplierResponseDTO> save(@Valid @RequestBody SupplierRequestDTO entity) {
        SupplierResponseDTO savedEntity = supplierService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SupplierUpdateRequestDTO entity) {
        SupplierResponseDTO updatedEntity = supplierService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }


}