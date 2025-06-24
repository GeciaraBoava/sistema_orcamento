package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.SupplierRequestDTO;
import com.geciara.orcamento.dto.SupplierResponseDTO;
import com.geciara.orcamento.dto.SupplierUpdateDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.SupplierMapper;
import com.geciara.orcamento.model.entitys.Supplier;
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
        Supplier supplier = supplierMapper.toEntity(dto);
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
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return supplierMapper.toResponseDTO(supplier);
    }

    public SupplierResponseDTO update(Long id, SupplierUpdateDTO dto) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        Supplier updatedSupplier = supplierMapper.updateFromDTO(dto, supplier);
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
