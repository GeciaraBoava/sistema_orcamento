package com.geciara.orcamento.dto;

import com.geciara.orcamento.model.enums.AcessType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDTO {

    private String name;
    private String phone;

    @Email(message = "Email inválido")
    private String email;

    private String adress;
    private String city;

    @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
    private String state;

    private AcessType acessType;
    private Boolean isActive;

}