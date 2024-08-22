package com.dms.user_entity_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "u_address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_address_id")
    private long addressId;

    @Column(name = "u_street")
    private String street;

    @Column(name = "u_area")
    private String area;

    @Column(name = "u_district")
    private String district;

    @Column(name = "u_state")
    private String state;

    @Column(name = "u_country")
    private String country;

    @Column(name = "u_zip_code")
    private String zipCode;

    @Column(name = "u_address_type")
    private String addressType;

    @Column(name = "u_user_rid")
    private long userRid;

    @Column(name = "u_entity_rid")
    private long entityRid;
}
