package com.geciara.orcamento.mapper;

import com.geciara.orcamento.dto.UserRequestDTO;
import com.geciara.orcamento.dto.UserResponseDTO;
import com.geciara.orcamento.dto.UserUpdateRequestDTO;
import com.geciara.orcamento.model.entitys.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User toUserEntity(UserRequestDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setAdress(dto.getAdress());
        user.setCity(dto.getCity());
        user.setState(dto.getState());
        user.setAcessType (dto.getAcessType());
        user.setRegisteredAt(LocalDateTime.now());
        user.setActive(true);
        user.setPassword("123456");

        return user;
    }

    public User updateEntityFromDTO(UserUpdateRequestDTO dto,
                                        User user) {
        if(dto.getName() != null) user.setName(dto.getName());
        if(dto.getPhone() != null) user.setPhone(dto.getPhone());
        if(dto.getEmail() != null) user.setEmail(dto.getEmail());
        if(dto.getAdress() != null) user.setAdress(dto.getAdress());
        if(dto.getCity() != null) user.setCity(dto.getCity());
        if(dto.getState() != null) user.setState(dto.getState());
        if(dto.getAcessType() != null) user.setAcessType(dto.getAcessType());
        if(dto.getIsActive() != null) user.setActive(dto.getIsActive());
        user.setUpdatedAt(LocalDateTime.now());

        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPhone(user.getPhone());
        dto.setEmail(user.getEmail());
        dto.setAdress(user.getAdress());
        dto.setCity(user.getCity());
        dto.setState(user.getState());
        dto.setAcessType(user.getAcessType());
        dto.setActive(user.isActive());
        dto.setRegisteredAt(user.getRegisteredAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        return dto;
    }

}