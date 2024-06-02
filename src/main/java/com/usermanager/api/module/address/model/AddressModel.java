package com.usermanager.api.module.address.model;

import com.usermanager.api.module.user.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private Long number;

    private String complement;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String state;

    @Column(name= "zip_code", nullable = false)
    private String zipCode;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private UserModel user;

    public AddressModel(
            String street,
            Long number,
            String complement,
            String city,
            String neighborhood,
            String state,
            String zipCode) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.neighborhood = neighborhood;
        this.state = state;
        this.zipCode = zipCode;
    }
}