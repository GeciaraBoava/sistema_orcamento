package com.geciara.orcamento.controller;

import com.geciara.orcamento.model.dto.MaterialPriceUpdateDTO;
import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.model.services.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

public class MaterialController extends GenericController<Material, MaterialService> {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        super(materialService);
        this.materialService = materialService;
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<Material> updatePrice(@PathVariable Long id, @RequestBody MaterialPriceUpdateDTO priceUpdate) {
        Material existingMaterial = materialService.findById(id);
        existingMaterial.setPrice(priceUpdate.getPrice());
        existingMaterial.setUpdateDate(LocalDateTime.now());

        Material updatedMaterial = materialService.update(id, existingMaterial);
        return ResponseEntity.ok(updatedMaterial);
    }
}
