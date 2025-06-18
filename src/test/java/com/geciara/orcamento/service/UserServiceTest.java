package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.UserRequestDTO;
import com.geciara.orcamento.dto.UserResponseDTO;
import com.geciara.orcamento.dto.UserUpdateRequestDTO;
<<<<<<< HEAD
import com.geciara.orcamento.exceptions.EmailAlreadyExistsException;
import com.geciara.orcamento.exceptions.UserNotFoundException;
import com.geciara.orcamento.mapper.UserMapper;
import com.geciara.orcamento.model.entitys.User;
import com.geciara.orcamento.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
=======
import com.geciara.orcamento.mapper.UserMapper;
import com.geciara.orcamento.model.entitys.User;
import com.geciara.orcamento.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4

import static com.geciara.orcamento.model.enums.UserRole.ADMIN;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

<<<<<<< HEAD
@ExtendWith(MockitoExtension.class)
=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

<<<<<<< HEAD
    private User user;
    private final LocalDateTime fixedTime = LocalDateTime.of(2025, 1, 1, 12, 0);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User(
            1L,
            "GeciaraBoava",
            "123456",
            ADMIN,
            "Geciara Boava",
            "99999 9999",
            "geciara@gmail.com",
            "Rua Fulano de Tal",
            "Curitiba",
            "PR",
            true,
            fixedTime,
            fixedTime
        );
    }

    @Test
    void shouldSaveUserSuccessfully() {

        UserRequestDTO requestDTO = new UserRequestDTO(
            "GeciaraBoava",
            "Geciara Boava",
            "000000009",
            "geciara@gmail.com",
            "Rua Fulano de Tal",
            "Curitiba",
            "PR",
            ADMIN
        );

        UserResponseDTO responseDTO = new UserResponseDTO(
            1L,
            "Geciara Boava",
            "GeciaraBoava",
            "000000009",
            "geciara@gmail.com",
            "Rua Fulano de Tal",
            "Curitiba",
            "PR",
            ADMIN,
            true,
            fixedTime,
            fixedTime
=======
    void testSaveUser() {

        UserRequestDTO requestDTO = new UserRequestDTO(
                "GeciaraBoava",
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
                "GeciaraBoava",
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
                "GeciaraBoava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                ADMIN,
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
        );

        when(userMapper.toUserEntity(requestDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toResponseDTO(user)).thenReturn(responseDTO);

        UserResponseDTO result = userService.save(requestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Geciara Boava", result.getName());
        assertEquals("GeciaraBoava", result.getLogin());
        assertEquals("000000009", result.getPhone());
        assertEquals("geciara@gmail.com", result.getEmail());
<<<<<<< HEAD
        assertEquals("Rua Fulano de Tal", result.getAddress());
=======
        assertEquals("Rua Fulano de tal", result.getAddress());
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
        assertEquals("Curitiba", result.getCity());
        assertEquals("PR", result.getState());
        assertEquals(ADMIN, result.getRole());

        verify(userRepository, times(1)).save(user);
        verify(userMapper, times(1)).toResponseDTO(user);

    }

<<<<<<< HEAD
    @Test
    void shouldUpdateUserSuccessfully() {
        UserUpdateRequestDTO updateRequestDTO = new UserUpdateRequestDTO(
            "Geciara Boava",
            "GeciaraBoava",
            "123456",
            "000000009",
            "geciara@gmail.com",
            "Rua Ciclano de Tal",
            "Curitiba",
            "PR",
            ADMIN,
            true
        );

        UserResponseDTO responseDTO = new UserResponseDTO(
            1L,
            "Geciara Boava",
            "GeciaraBoava",
            "000000009",
            "geciara@gmail.com",
            "Rua Fulano de Tal",
            "Curitiba",
            "PR",
            ADMIN,
            true,
            fixedTime,
            fixedTime
=======
    void testUpdateUser() {
        UserUpdateRequestDTO updateRequestDTO = new UserUpdateRequestDTO(
                "Geciara Boava",
                "GeciaraBoava",
                "123456",
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
                "GeciaraBoava",
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
                "GeciaraBoava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                ADMIN,
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
        );

        when(userMapper.updateEntityFromDTO(updateRequestDTO, user)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toResponseDTO(user)).thenReturn(responseDTO);

        UserResponseDTO result = userService.update(user.getId(), updateRequestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Geciara Boava", result.getName());
        assertEquals("GeciaraBoava", result.getLogin());
        assertEquals("000000009", result.getPhone());
        assertEquals("geciara@gmail.com", result.getEmail());
        assertEquals("Rua Fulano de tal", result.getAddress());
        assertEquals("Curitiba", result.getCity());
        assertEquals("PR", result.getState());
        assertEquals(ADMIN, result.getRole());

        verify(userRepository, times(1)).save(user);
        verify(userMapper, times(1)).toResponseDTO(user);
    }
<<<<<<< HEAD

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExistsOnSave() {
        UserRequestDTO requestDTO = new UserRequestDTO(
                "GeciaraBoava",
                "Geciara Boava",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                ADMIN
        );

        when(userRepository.existsByEmail(requestDTO.getEmail())).thenReturn(true);

        EmailAlreadyExistsException exception = assertThrows(
                EmailAlreadyExistsException.class,
                () -> userService.save(requestDTO)
        );

        assertEquals("Email já está em uso.", exception.getMessage());
        verify(userRepository, never()).save(any());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFoundOnUpdate() {
        Long invalidId = 99L;
        UserUpdateRequestDTO updateRequestDTO = new UserUpdateRequestDTO(
                "Geciara Boava",
                "GeciaraBoava",
                "123456",
                "000000009",
                "geciara@gmail.com",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                ADMIN,
                true
        );

        when(userRepository.findById(invalidId)).thenReturn(Optional.empty());

        UserNotFoundException exception = assertThrows(
                UserNotFoundException.class,
                () -> userService.update(invalidId, updateRequestDTO)
        );

        assertEquals("Usuário não encontrado.", exception.getMessage());
        verify(userRepository, never()).save(any());
    }

    @Test
    void shouldThrowExceptionWhenSavingWithInvalidEmail() {
        UserRequestDTO requestDTO = new UserRequestDTO(
                "GeciaraBoava",
                "Geciara Boava",
                "000000009",
                "email-invalido",
                "Rua Fulano de Tal",
                "Curitiba",
                "PR",
                ADMIN
        );

        assertThrows(ConstraintViolationException.class, () -> userService.save(requestDTO));
    }

=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
}
