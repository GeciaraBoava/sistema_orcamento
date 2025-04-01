package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.SupplierRequestDTO;
import com.geciara.orcamento.dto.SupplierResponseDTO;
import com.geciara.orcamento.dto.SupplierUpdateRequestDTO;
import com.geciara.orcamento.model.entitys.Supplier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SupplierMapper {
    public Supplier toSupplierEntity(SupplierRequestDTO dto) {

        Supplier supplier = new Supplier();

        supplier.setName(dto.getName());
        supplier.setPhone(dto.getPhone());
        supplier.setContactName(dto.getContactName());
        supplier.setEmail(dto.getEmail());
        supplier.setAdress(dto.getAdress());
        supplier.setCity(dto.getCity());
        supplier.setState(dto.getState());
        supplier.setRegisteredAt(LocalDateTime.now());
        supplier.setActive(true);

        return supplier;
    }

    public Supplier updateEntityFromDTO(SupplierUpdateRequestDTO dto,
                                        Supplier supplier) {
        if(dto.getName() != null) supplier.setName(dto.getName());
        if(dto.getPhone() != null) supplier.setPhone(dto.getPhone());
        if(dto.getContactName() != null) supplier.setContactName(dto.getContactName());
        if(dto.getEmail() != null) supplier.setEmail(dto.getEmail());
        if(dto.getAdress() != null) supplier.setAdress(dto.getAdress());
        if(dto.getCity() != null) supplier.setCity(dto.getCity());
        if(dto.getState() != null) supplier.setState(dto.getState());
        if(dto.getIsActive() != null) supplier.setActive(dto.getIsActive());
        supplier.setUpdatedAt(LocalDateTime.now());

        return supplier;
    }

    public SupplierResponseDTO toResponseDTO(Supplier supplier) {
        SupplierResponseDTO dto = new SupplierResponseDTO();

        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setPhone(supplier.getPhone());
        dto.setContactName(supplier.getContactName());
        dto.setEmail(supplier.getEmail());
        dto.setAdress(supplier.getAdress());
        dto.setCity(supplier.getCity());
        dto.setState(supplier.getState());
        dto.setActive(supplier.isActive());
        dto.setRegisteredAt(supplier.getRegisteredAt());
        dto.setUpdatedAt(supplier.getUpdatedAt());

        return dto;
    }

}