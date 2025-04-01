package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.UserRequestDTO;
import com.geciara.orcamento.dto.UserResponseDTO;
import com.geciara.orcamento.dto.UserUpdateRequestDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.UserMapper;
import com.geciara.orcamento.model.entitys.User;
import com.geciara.orcamento.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO save(UserRequestDTO dto) {
        User user = userMapper.toUserEntity(dto);
        user = userRepository.save(user);
        return userMapper.toResponseDTO(user);
    }

    public List<UserResponseDTO> listAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return userMapper.toResponseDTO(user);
    }

    public UserResponseDTO update(Long id, UserUpdateRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        User updatedUser = userMapper.updateEntityFromDTO(dto, user);
        userRepository.save(updatedUser);
        return userMapper.toResponseDTO(updatedUser);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        userRepository.deleteById(id);
    }

}