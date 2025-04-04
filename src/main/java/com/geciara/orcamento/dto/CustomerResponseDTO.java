package com.geciara.orcamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.model.enums.CustomerType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerResponseDTO {

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

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;
}