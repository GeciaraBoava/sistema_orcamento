package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.SupplierRequestDTO;
import com.geciara.orcamento.dto.SupplierResponseDTO;
import com.geciara.orcamento.dto.SupplierUpdateRequestDTO;
import com.geciara.orcamento.model.entitys.SupplierEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SupplierMapper {
    public SupplierEntity toSupplierEntity(SupplierRequestDTO dto) {

        SupplierEntity supplier = new SupplierEntity();

        supplier.setName(dto.getName());
        supplier.setPhone(dto.getPhone());
        supplier.setContactName(dto.getContactName());
        supplier.setEmail(dto.getEmail());
        supplier.setAddress(dto.getAddress());
        supplier.setCity(dto.getCity());
        supplier.setState(dto.getState());
        supplier.setRegisteredAt(LocalDateTime.now());
        supplier.setActive(true);

        return supplier;
    }

    public SupplierEntity updateEntityFromDTO(SupplierUpdateRequestDTO dto,
                                              SupplierEntity supplier) {
        if(dto.getName() != null) supplier.setName(dto.getName());
        if(dto.getPhone() != null) supplier.setPhone(dto.getPhone());
        if(dto.getContactName() != null) supplier.setContactName(dto.getContactName());
        if(dto.getEmail() != null) supplier.setEmail(dto.getEmail());
        if(dto.getAddress() != null) supplier.setAddress(dto.getAddress());
        if(dto.getCity() != null) supplier.setCity(dto.getCity());
        if(dto.getState() != null) supplier.setState(dto.getState());
        if(dto.getIsActive() != null) supplier.setActive(dto.getIsActive());
        supplier.setUpdatedAt(LocalDateTime.now());

        return supplier;
    }

    public SupplierResponseDTO toResponseDTO(SupplierEntity supplier) {
        SupplierResponseDTO dto = new SupplierResponseDTO();

        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setPhone(supplier.getPhone());
        dto.setContactName(supplier.getContactName());
        dto.setEmail(supplier.getEmail());
        dto.setAddress(supplier.getAddress());
        dto.setCity(supplier.getCity());
        dto.setState(supplier.getState());
        dto.setActive(supplier.isActive());
        dto.setCreatedBy(supplier.getCreatedBy());
        dto.setUpdatedBy(supplier.getUpdatedBy());
        dto.setRegisteredAt(supplier.getRegisteredAt());
        dto.setUpdatedAt(supplier.getUpdatedAt());

        return dto;
    }

}