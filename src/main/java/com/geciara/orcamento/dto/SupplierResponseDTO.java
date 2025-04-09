package com.geciara.orcamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.model.enums.CustomerType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SupplierResponseDTO {

    private Long id;
    private String name;
    private String phone;
    private String contactName;
    private String email;
    private String address;
    private String city;
    private String state;
    private CustomerType customerType;
    private boolean isActive;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
}