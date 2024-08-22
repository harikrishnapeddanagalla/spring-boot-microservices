package com.dms.user_entity_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "u_user")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_rid")
    private long userRid;  // Primary Key
    
    @Column(name = "user_id", nullable = false, unique = true)
    private String userID;
    
    @Column(name = "user_password", nullable = false)
    private String password;
    
    @Column(name = "user_email")
    private String email;
    
    @Column(name = "user_phone_number")
    private String phoneNumber;
    
    @Column(name = "user_is_valid")
    private long isValid;
    
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;  // Foreign Key to Address
    
    @ManyToOne
    @JoinColumn(name = "ent_rid", nullable = false)
    private UEntity entity;  // Foreign Key relationship
}
