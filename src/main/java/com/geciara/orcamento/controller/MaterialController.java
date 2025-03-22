package com.geciara.orcamento.controller;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.model.services.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<Material>> listAllMaterials() {
        List<Material> materials = materialService.listAll();
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> findMaterialById(@PathVariable Long id) {
        Material material = materialService.findById(id);
        return ResponseEntity.ok(material);
    }

    @PostMapping
    public Material saveMaterial(@RequestBody Material material) {
        return materialService.save(material);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable Long id) {
        materialService.delete(id);
    }

    @PutMapping("/{id}/price")
    public ResponseEntity<String> updatePriceMaterial(@PathVariable Long id, @RequestBody BigDecimal newPrice) {

        materialService.updateMaterialPrice(id, newPrice);
        return ResponseEntity.ok("Preço do insumo atualizado com sucesso");
    }

}
