package com.usermanager.api.module.address.dto;

public record RAddressDto(
        Long id,
        String street,
        Long number,
        String complement,
        String city,
        String neighborhood,
        String state,
        String zipCode
) { }