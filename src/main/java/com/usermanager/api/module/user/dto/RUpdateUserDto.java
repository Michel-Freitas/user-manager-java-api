package com.usermanager.api.module.user.dto;

import com.usermanager.api.module.user.enums.EUserRole;
import com.usermanager.api.module.user.enums.EUserStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record RUpdateUserDto(
        @NotNull(message = "Id Obrigatório.")
        Long id,

        @NotEmpty(message = "Nome Obrigatório.")
        @Length(min = 3, message = "Nome precisa ser no minimo 3 caracteres.")
        String name,

        @NotNull(message = "Data de Nasimento Obrigatória.")
        Date dateBirth,

        @NotNull(message = "Role Obrigatória.")
        EUserRole role,

        @NotNull(message = "Status Obrigatória.")
        EUserStatus status
) { }
