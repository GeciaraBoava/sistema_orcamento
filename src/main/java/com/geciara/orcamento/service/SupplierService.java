package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.SupplierRequestDTO;
import com.geciara.orcamento.dto.SupplierResponseDTO;
import com.geciara.orcamento.dto.SupplierUpdateRequestDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.SupplierMapper;
import com.geciara.orcamento.model.entitys.SupplierEntity;
import com.geciara.orcamento.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierService(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }


    public SupplierResponseDTO save(SupplierRequestDTO dto) {
        SupplierEntity supplier = supplierMapper.toSupplierEntity(dto);
        supplier = supplierRepository.save(supplier);
        return supplierMapper.toResponseDTO(supplier);
    }

    public List<SupplierResponseDTO> listAll() {
        return supplierRepository.findAll()
                .stream()
                .map(supplierMapper::toResponseDTO)
                .toList();
    }

    public SupplierResponseDTO findById(Long id) {
        SupplierEntity supplier = supplierRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return supplierMapper.toResponseDTO(supplier);
    }

    public SupplierResponseDTO update(Long id, SupplierUpdateRequestDTO dto) {
        SupplierEntity supplier = supplierRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        SupplierEntity updatedSupplier = supplierMapper.updateEntityFromDTO(dto, supplier);
        supplierRepository.save(updatedSupplier);
        return supplierMapper.toResponseDTO(updatedSupplier);
    }

    public void delete(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        supplierRepository.deleteById(id);
    }

}
