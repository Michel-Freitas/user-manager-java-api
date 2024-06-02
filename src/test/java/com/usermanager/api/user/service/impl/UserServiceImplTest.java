package com.usermanager.api.user.service.impl;

import com.usermanager.api.user.dto.RCreateUserDto;
import com.usermanager.api.user.enums.EUserRole;
import com.usermanager.api.user.enums.EUserStatus;
import com.usermanager.api.user.model.UserModel;
import com.usermanager.api.user.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private IUserRepository userRepository;

    @Autowired
    @InjectMocks
    private UserServiceImpl userService;

    private RCreateUserDto userDto;

    @BeforeEach
    void setup() {
        String name = "Michel Freitas";
        String cpf = "12345678901";
        EUserRole role = EUserRole.COMMON;

        this.userDto = new RCreateUserDto(name, cpf, new Date(), role);
        UserModel user = new UserModel(1L, name, cpf, new Date(), role, EUserStatus.ACTIVE);
        Mockito.lenient().when(this.userRepository.save(any(UserModel.class))).thenReturn(user);
    }

    @Test
    @DisplayName("Successful user creation.")
    void successfulUserCreation() {
        // Arrange
        when(this.userRepository.existsByCpf(any(String.class))).thenReturn(false);

        // Act
        UserModel result = this.userService.create(this.userDto);

        // Assert
        assertEquals(result.getCpf(), this.userDto.cpf());
        assertEquals(result.getName(), this.userDto.name());
    }

    @Test
    @DisplayName("Failed to create a user with an existing CPF")
    void failedCreateUserWithExistingCpf() {
        // Arrange
        when(this.userRepository.existsByCpf(any(String.class))).thenReturn(true);

        // Act
        Exception result = Assertions.assertThrows(Exception.class, () -> {
            this.userService.create(this.userDto);
        });

        // Assert
        assertEquals(result.getMessage(), "CPF já está em uso.");
    }
}