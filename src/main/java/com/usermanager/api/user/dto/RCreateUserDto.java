package com.usermanager.api.user.dto;

import com.usermanager.api.user.enums.EUserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record RCreateUserDto(
        @NotEmpty(message = "Nome Obrigatorio.")
        @Length(min = 3, message = "Nome precisa ser no minimo 3 caracteres.")
        String name,

        @NotEmpty(message = "CPF Obrigatorio.")
        @Size(min = 11, max = 11, message = "O CPF precisa ter 11 caracteres.")
        String cpf,

        @NotNull(message = "Nome Obrigatorio.")
        Date dateBirth,

        EUserRole role) {
        public RCreateUserDto {
                role = (role == null ? EUserRole.COMMON : role);
        }
}
