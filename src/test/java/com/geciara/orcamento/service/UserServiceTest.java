package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.UserRequestDTO;
import com.geciara.orcamento.dto.UserResponseDTO;
import com.geciara.orcamento.dto.UserUpdateRequestDTO;
import com.geciara.orcamento.mapper.UserMapper;
import com.geciara.orcamento.model.entitys.User;
import com.geciara.orcamento.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static com.geciara.orcamento.model.enums.AcessType.ADMIN;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    void testSaveUser() {

        UserRequestDTO requestDTO = new UserRequestDTO(
                "Geciara Boava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de tal",
                "Curitiba",
                "PR",
                ADMIN
        );

        User user = new User(
                "Geciara Boava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                "123456",
                ADMIN
        );

        UserResponseDTO responseDTO = new UserResponseDTO(
                1L,
                "Geciara Boava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                ADMIN,
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        when(userMapper.toUserEntity(requestDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toResponseDTO(user)).thenReturn(responseDTO);

        UserResponseDTO result = userService.save(requestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Geciara Boava", result.getName());
        assertEquals("000000009", result.getPhone());
        assertEquals("geciara@gmail.com", result.getEmail());
        assertEquals("Rua Fulano de tal", result.getAdress());
        assertEquals("Curitiba", result.getCity());
        assertEquals("PR", result.getState());
        assertEquals(ADMIN, result.getAcessType());

        verify(userRepository, times(1)).save(user);
        verify(userMapper, times(1)).toResponseDTO(user);

    }

    void testUpdateUser() {
        UserUpdateRequestDTO updateRequestDTO = new UserUpdateRequestDTO(
                "Geciara Boava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                ADMIN,
                true
        );

        User user = new User(
                "Geciara Boava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                "123456",
                ADMIN
        );

        UserResponseDTO responseDTO = new UserResponseDTO(
                1L,
                "Geciara Boava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                ADMIN,
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        when(userMapper.updateEntityFromDTO(updateRequestDTO, user)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toResponseDTO(user)).thenReturn(responseDTO);

        UserResponseDTO result = userService.update(user.getId(), updateRequestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Geciara Boava", result.getName());
        assertEquals("000000009", result.getPhone());
        assertEquals("geciara@gmail.com", result.getEmail());
        assertEquals("Rua Fulano de tal", result.getAdress());
        assertEquals("Curitiba", result.getCity());
        assertEquals("PR", result.getState());
        assertEquals(ADMIN, result.getAcessType());

        verify(userRepository, times(1)).save(user);
        verify(userMapper, times(1)).toResponseDTO(user);
    }
}
