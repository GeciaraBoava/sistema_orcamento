package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.CustomerRequestDTO;
import com.geciara.orcamento.dto.CustomerResponseDTO;
import com.geciara.orcamento.dto.CustomerUpdateRequestDTO;
import com.geciara.orcamento.model.entitys.CustomerEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerMapper {
    public CustomerEntity toCustomerEntity(CustomerRequestDTO dto) {

        CustomerEntity customer = new CustomerEntity();

        customer.setName(dto.getName());
        customer.setPhone(dto.getPhone());
        customer.setContactName(dto.getContactName());
        customer.setEmail(dto.getEmail());
        customer.setAddress(dto.getAddress());
        customer.setCity(dto.getCity());
        customer.setState(dto.getState());
        customer.setCustomerType(dto.getCustomerType());
        customer.setRegisteredAt(LocalDateTime.now());
        customer.setActive(true);

        return customer;
    }

    public CustomerEntity updateEntityFromDTO(CustomerUpdateRequestDTO dto,
                                              CustomerEntity customer) {
        if(dto.getName() != null) customer.setName(dto.getName());
        if(dto.getPhone() != null) customer.setPhone(dto.getPhone());
        if(dto.getContactName() != null) customer.setContactName(dto.getContactName());
        if(dto.getEmail() != null) customer.setEmail(dto.getEmail());
        if(dto.getAddress() != null) customer.setAddress(dto.getAddress());
        if(dto.getCity() != null) customer.setCity(dto.getCity());
        if(dto.getState() != null) customer.setState(dto.getState());
        if(dto.getCustomerType() != null) customer.setCustomerType(dto.getCustomerType());
        if(dto.getIsActive() != null) customer.setActive(dto.getIsActive());
        customer.setUpdatedAt(LocalDateTime.now());

        return customer;
    }

    public CustomerResponseDTO toResponseDTO(CustomerEntity customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();

        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setPhone(customer.getPhone());
        dto.setContactName(customer.getContactName());
        dto.setEmail(customer.getEmail());
        dto.setAddress(customer.getAddress());
        dto.setCity(customer.getCity());
        dto.setState(customer.getState());
        dto.setCustomerType(customer.getCustomerType());
        dto.setActive(customer.isActive());
        dto.setCreatedBy(customer.getCreatedBy());
        dto.setUpdatedBy(customer.getUpdatedBy());
        dto.setRegisteredAt(customer.getRegisteredAt());
        dto.setUpdatedAt(customer.getUpdatedAt());

        return dto;
    }

}