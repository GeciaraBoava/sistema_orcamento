package com.geciara.orcamento.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geciara.orcamento.model.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDTO {

    private String name;
    private String login;

    @JsonIgnore
    private String password;
    private String phone;

    @Email(message = "Email inválido")
    private String email;

    private String address;
    private String city;

    @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
    private String state;

    private UserRole role;
    private Boolean isActive;

}