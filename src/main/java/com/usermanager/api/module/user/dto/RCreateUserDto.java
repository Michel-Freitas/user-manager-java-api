package com.usermanager.api.module.user.dto;

import com.usermanager.api.module.address.dto.RCreateAddressDto;
import com.usermanager.api.module.user.enums.EUserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record RCreateUserDto(
        @NotEmpty(message = "Nome Obrigatório.")
        @Length(min = 3, message = "Nome precisa ser no minimo 3 caracteres.")
        String name,

        @NotEmpty(message = "CPF Obrigatório.")
        @Size(min = 11, max = 11, message = "O CPF precisa ter 11 caracteres.")
        String cpf,

        @NotNull(message = "Data de Nasimento Obrigatória.")
        Date dateBirth,

        EUserRole role,

        @NotNull(message = "Endereço Obrigatório.")
        RCreateAddressDto address
        ) {
        public RCreateUserDto {
                role = (role == null ? EUserRole.COMMON : role);
        }
}
