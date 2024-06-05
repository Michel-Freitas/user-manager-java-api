package com.usermanager.api.module.user.dto;

import com.usermanager.api.module.address.dto.RAddressDto;
import com.usermanager.api.module.user.enums.EUserRole;
import com.usermanager.api.module.user.enums.EUserStatus;

import java.util.Date;

public record RUserDetailsDto(
        Long id,
        String name,
        String cpf,
        Date dateBirth,
        EUserRole role,
        EUserStatus status,
        RAddressDto address
) { }
