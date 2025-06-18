package com.geciara.orcamento.dto;

import com.geciara.orcamento.model.enums.CustomerType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "Telefone é obrigatório")
    private String phone;

    @NotBlank(message = "Nome de contato é obrigatório")
    private String contactName;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Endereço é obrigatório")
    private String address;

    @NotBlank(message = "Cidade é obrigatória")
    private String city;

    @NotBlank(message = "Estado é obrigatório")
    @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
    private String state;

    @NotNull(message = "Tipo de cliente é obrigatório")
    private CustomerType customerType;

}