package com.geciara.orcamento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String name;
    private String login;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private UserRole role;
    private boolean isActive;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
}