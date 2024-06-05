package com.usermanager.api.module.user.dto;

import com.usermanager.api.module.user.enums.EUserRole;
import com.usermanager.api.module.user.enums.EUserStatus;

import java.util.Date;

public record RUserDto(
        Long id,
        String name,
        String cpf,
        Date dateBirth,
        EUserRole role,
        EUserStatus status
) { }
