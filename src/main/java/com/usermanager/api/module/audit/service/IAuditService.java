package com.usermanager.api.module.audit.service;

import com.usermanager.api.module.audit.enums.ETypeAction;
import com.usermanager.api.module.user.model.UserModel;

public interface IAuditService {
    void logAction(UserModel user, ETypeAction action);
}
