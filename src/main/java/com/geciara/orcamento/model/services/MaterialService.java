package com.geciara.orcamento.service;

import com.geciara.orcamento.entitys.Material;
import com.geciara.orcamento.exceptions.MaterialNotFoundException;
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

    public Material findMaterialById(Long id) throws MaterialNotFoundException {
        return materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException("Material não encontrado com o ID: " + id));
    }

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);

    }

    public void updateMaterialPrice(Long id, Double newPrice) throws MaterialNotFoundException {
        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException("Material não encontrado"));

        material.setPrice(newPrice);
        materialRepository.save(material);
    }

}
