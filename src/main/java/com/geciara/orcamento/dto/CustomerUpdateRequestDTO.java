package com.geciara.orcamento.dto;

import com.geciara.orcamento.model.enums.CustomerType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerUpdateRequestDTO {

    private String name;
    private String phone;
    private String contactName;

    @Email(message = "Email inválido")
    private String email;

    private String adress;
    private String city;

    @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
    private String state;

    private CustomerType customerType;
    private Boolean isActive;
}