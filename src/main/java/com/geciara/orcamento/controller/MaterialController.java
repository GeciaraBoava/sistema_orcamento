package com.geciara.orcamento.controller;

import com.geciara.orcamento.model.Material;
import com.geciara.orcamento.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<Material> listAllMaterials() {
        return materialService.listAllMaterials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> findMaterialById(@PathVariable Long id) {
        try {
            Material material = materialService.findMaterialById(id);
            return ResponseEntity.ok(material);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

    @PostMapping
    public Material saveMaterial(@RequestBody Material material) {
        return materialService.saveMaterial(material);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
    }

    @PutMapping("/{id}/price")
    public ResponseEntity<String> updatePriceMaterial(@PathVariable Long id, @RequestBody Double newPrice) {
        try {
            materialService.updateMaterialPrice(id, newPrice);
            return ResponseEntity.ok("Preço do insumo atualizado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}
