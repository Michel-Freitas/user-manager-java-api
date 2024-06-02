package com.usermanager.api.module.user.dto;

import com.usermanager.api.module.address.dto.RUpdateAddressDto;
import com.usermanager.api.module.user.enums.EUserRole;
import com.usermanager.api.module.user.enums.EUserStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record RUpdateUserDto(
        @NotNull(message = "Id Obrigatório.")
        Long id,

        @NotEmpty(message = "Nome Obrigatório.")
        @Length(min = 3, message = "Nome precisa ser no minimo 3 caracteres.")
        String name,

        @NotEmpty(message = "CPF Obrigatório.")
        @Size(min = 11, max = 11, message = "O CPF precisa ter 11 caracteres.")
        String cpf,

        @NotNull(message = "Data de Nasimento Obrigatória.")
        Date dateBirth,

        @NotNull(message = "Role Obrigatória.")
        EUserRole role,

        @NotNull(message = "Status Obrigatória.")
        EUserStatus status,

        @NotNull(message = "Endereço Obrigatório.")
        RUpdateAddressDto address
) { }
