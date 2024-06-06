package com.usermanager.api.module.audit.enums;

import lombok.Getter;

@Getter
public enum ETypeAction {
    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    private final String action;

    ETypeAction(String action) { this.action = action; }
}
