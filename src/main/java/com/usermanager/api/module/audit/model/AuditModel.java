package com.usermanager.api.module.audit.model;

import com.usermanager.api.module.audit.enums.ETypeAction;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_audit")
public class AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ETypeAction action;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "user_id_performed", nullable = false)
    private Long userIdPerformedAction;

    @Column(name = "user_id_suffered", nullable = false)
    private Long userIdSufferedAction;

    @Column(name = "data")
    private String data;

    public AuditModel(ETypeAction action, Long userIdPerformedAction, Long userIdSufferedAction, String data) {
        this.action = action;
        this.userIdPerformedAction = userIdPerformedAction;
        this.userIdSufferedAction = userIdSufferedAction;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
