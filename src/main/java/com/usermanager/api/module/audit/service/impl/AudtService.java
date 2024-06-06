package com.usermanager.api.module.audit.service.impl;

import com.usermanager.api.module.audit.enums.ETypeAction;
import com.usermanager.api.module.audit.model.AuditModel;
import com.usermanager.api.module.audit.repository.IAuditRepository;
import com.usermanager.api.module.audit.service.IAuditService;
import com.usermanager.api.module.auth.service.IAuthService;
import com.usermanager.api.module.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudtService implements IAuditService {

    @Autowired
    private IAuditRepository auditRepository;

    @Autowired
    private IAuthService authService;

    @Override
    public void logAction(UserModel user, ETypeAction action) {
        long userId = action == ETypeAction.CREATE ? user.getId() : this.authService.authenticatedUserId();

        AuditModel audit = new AuditModel(
                action,
                userId,
                user.getId(),
                user.toString()
        );

        this.auditRepository.save(audit);
    }
}
