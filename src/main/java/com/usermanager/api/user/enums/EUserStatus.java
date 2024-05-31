package com.usermanager.api.user.enums;

import lombok.Getter;

@Getter
public enum EUserStatus {
    ACTIVE("ACTIVE"),
    REMOVED("REMOVED");

    private final String userStatus;

    EUserStatus(String userStatus) { this.userStatus = userStatus; }
}
