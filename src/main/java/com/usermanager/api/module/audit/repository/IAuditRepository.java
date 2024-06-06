package com.usermanager.api.module.audit.repository;

import com.usermanager.api.module.audit.model.AuditModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuditRepository extends JpaRepository<AuditModel, Long> {
}
