package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.MaterialRequestDTO;
import com.geciara.orcamento.dto.MaterialResponseDTO;
import com.geciara.orcamento.dto.MaterialUpdateRequestDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.MaterialMapper;
import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public MaterialService(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    public MaterialResponseDTO save(MaterialRequestDTO dto) {
        Material material = materialMapper.toMaterialEntity(dto);
        material = materialRepository.save(material);
        return materialMapper.toResponseDTO(material);
    }

    public List<MaterialResponseDTO> listAll() {
        return materialRepository.findAll()
                .stream()
                .map(materialMapper::toResponseDTO)
                .toList();
    }

    public MaterialResponseDTO findById(Long id) {
        Material material = materialRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return materialMapper.toResponseDTO(material);
    }

    public MaterialResponseDTO update(Long id, MaterialUpdateRequestDTO dto) {
        Material material = materialRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        Material updatedMaterial = materialMapper.updateEntityFromDTO(dto, material);
        materialRepository.save(updatedMaterial);
        return materialMapper.toResponseDTO(updatedMaterial);
    }

    public void delete(Long id) {
        if (!materialRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        materialRepository.deleteById(id);
    }



}