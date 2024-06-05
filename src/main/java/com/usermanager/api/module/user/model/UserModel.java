package com.usermanager.api.module.user.model;

import com.usermanager.api.module.address.model.AddressModel;
import com.usermanager.api.module.user.enums.EUserRole;
import com.usermanager.api.module.user.enums.EUserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "date_birth", nullable = false)
    private Date dateBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EUserRole role;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EUserStatus status;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressModel address;

    public UserModel(String name, String password, String cpf, Date dateBirth, EUserRole role, AddressModel address) {
        this.name = name;
        this.cpf = cpf;
        this.dateBirth = dateBirth;
        this.role = role;
        this.status = EUserStatus.ACTIVE;
        this.address = address;
        this.password = password;
    }

    public void changeStatus() {
        if (this.status == EUserStatus.ACTIVE) {
            this.setStatus(EUserStatus.REMOVED);
        } else {
            this.setStatus(EUserStatus.ACTIVE);
        }
    }
}