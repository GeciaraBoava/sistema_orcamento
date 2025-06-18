package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.UserRequestDTO;
import com.geciara.orcamento.dto.UserResponseDTO;
import com.geciara.orcamento.dto.UserUpdateRequestDTO;
import com.geciara.orcamento.model.entitys.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    private final BCryptPasswordEncoder passwordEncoder;

    public UserMapper(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User toUserEntity(UserRequestDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setLogin(dto.getLogin());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setState(dto.getState());
        user.setRole(dto.getRole());
        user.setRegisteredAt(LocalDateTime.now());
        user.setActive(true);
        user.setPassword(passwordEncoder.encode("123456")); //senha padrão a ser alterada pelo 'user'

        return user;
    }

    public User updateEntityFromDTO(UserUpdateRequestDTO dto,
                                        User user) {
        if(dto.getName() != null) user.setName(dto.getName());
        if(dto.getLogin() != null) user.setLogin(dto.getLogin());
        if(dto.getPassword() != null) user.setPassword(passwordEncoder.encode(dto.getPassword()));
        if(dto.getPhone() != null) user.setPhone(dto.getPhone());
        if(dto.getEmail() != null) user.setEmail(dto.getEmail());
        if(dto.getAddress() != null) user.setAddress(dto.getAddress());
        if(dto.getCity() != null) user.setCity(dto.getCity());
        if(dto.getState() != null) user.setState(dto.getState());
        if(dto.getRole() != null) user.setRole(dto.getRole());
        if(dto.getIsActive() != null) user.setActive(dto.getIsActive());
        user.setUpdatedAt(LocalDateTime.now());

        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLogin(user.getLogin());
        dto.setPhone(user.getPhone());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setCity(user.getCity());
        dto.setState(user.getState());
        dto.setRole(user.getRole());
        dto.setActive(user.isActive());
        dto.setRegisteredAt(user.getRegisteredAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        return dto;
    }

}