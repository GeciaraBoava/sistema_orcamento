package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.MaterialTypeRequestDTO;
import com.geciara.orcamento.dto.MaterialTypeResponseDTO;
import com.geciara.orcamento.dto.MaterialTypeUpdateRequestDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.MaterialTypeMapper;
import com.geciara.orcamento.model.entitys.MaterialType;
import com.geciara.orcamento.repository.MaterialTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterialTypeService {

    private final MaterialTypeRepository MaterialTypeRepository;
    private final MaterialTypeMapper MaterialTypeMapper;

    public MaterialTypeService(MaterialTypeRepository MaterialTypeRepository, MaterialTypeMapper MaterialTypeMapper) {
        this.MaterialTypeRepository = MaterialTypeRepository;
        this.MaterialTypeMapper = MaterialTypeMapper;
    }

    public MaterialTypeResponseDTO save(MaterialTypeRequestDTO dto) {
        MaterialType MaterialType = MaterialTypeMapper.toMaterialTypeEntity(dto);
        MaterialType = MaterialTypeRepository.save(MaterialType);
        return MaterialTypeMapper.toResponseDTO(MaterialType);
    }

    public List<MaterialTypeResponseDTO> listAll() {
        return MaterialTypeRepository.findAll()
                .stream()
                .map(MaterialTypeMapper::toResponseDTO)
                .toList();
    }

    public MaterialTypeResponseDTO findById(Long id) {
        MaterialType MaterialType = MaterialTypeRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return MaterialTypeMapper.toResponseDTO(MaterialType);
    }

    public MaterialTypeResponseDTO update(Long id, MaterialTypeUpdateRequestDTO dto) {
        MaterialType MaterialType = MaterialTypeRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        MaterialType updatedMaterialType = MaterialTypeMapper.updateEntityFromDTO(dto, MaterialType);
        MaterialTypeRepository.save(updatedMaterialType);
        return MaterialTypeMapper.toResponseDTO(updatedMaterialType);
    }

    public void delete(Long id) {
        if (!MaterialTypeRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        MaterialTypeRepository.deleteById(id);
    }


}
