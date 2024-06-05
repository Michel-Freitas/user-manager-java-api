package com.usermanager.api.module.address.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RUpdateAddressDto(
        @NotNull(message = "Id Obrigatório.")
        Long id,

        @NotEmpty(message = "Rua Obrigatório.")
        String street,

        @NotEmpty(message = "Número Obrigatório.")
        Long number,

        @NotEmpty(message = "Cidade Obrigatório.")
        String city,

        @NotEmpty(message = "Bairro Obrigatório.")
        String neighborhood,

        @NotEmpty(message = "Estado Obrigatório.")
        String state,

        @NotEmpty(message = "CEP Obrigatório.")
        @Size(min = 8, max = 8, message = "O CEP precisa ter 8 caracteres.")
        String zipCode,

        String complement
) { }
