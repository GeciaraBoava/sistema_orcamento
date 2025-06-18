package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.UserRequestDTO;
import com.geciara.orcamento.dto.UserResponseDTO;
import com.geciara.orcamento.dto.UserUpdateRequestDTO;
<<<<<<< HEAD
import com.geciara.orcamento.exceptions.EmailAlreadyExistsException;
=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.UserMapper;
import com.geciara.orcamento.model.entitys.User;
import com.geciara.orcamento.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO save(UserRequestDTO dto) {
<<<<<<< HEAD

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException("Email já está em uso.");
        }

=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
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

    public void updatePassword(Long id, String novaSenha) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Usuário não encontrado"));
        user.setPassword(passwordEncoder.encode(novaSenha));
        userRepository.save(user);
    }


}