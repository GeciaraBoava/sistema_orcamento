package com.geciara.orcamento.service;

import com.geciara.orcamento.model.Material;
import com.geciara.orcamento.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> listAllMaterials() {
        return materialRepository.findAll();

    }

    public Material findMaterialById(Long id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material não encontrado com o ID: " + id));
    }

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);

    }

    public void updateMaterialPrice(Long id, Double newPrice) {
        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));

        material.setPrice(newPrice);
        materialRepository.save(material);
    }


}
