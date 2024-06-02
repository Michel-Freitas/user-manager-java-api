package com.usermanager.api.module.user.enums;

import lombok.Getter;

@Getter
public enum EUserRole {
    ADMIN("ADMIN"),
    COMMON("COMMON");

    private final String userRole;

    EUserRole(String userRole) { this.userRole = userRole; }
}
