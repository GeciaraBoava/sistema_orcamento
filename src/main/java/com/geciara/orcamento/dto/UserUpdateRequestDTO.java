package com.geciara.orcamento.dto;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
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
<<<<<<< HEAD

    @JsonIgnore
=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
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