package com.dms.user_entity_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "u_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ent_rid")
    private long entRid;

    @Column(name = "ent_code", nullable = false, unique = true)
    private String entCode;

    @Column(name = "ent_name", nullable = false)
    private String entName;

    @Column(name = "ent_type", nullable = false)
    private String entType;

    @OneToOne
    @JoinColumn(name = "u_address_id", referencedColumnName = "u_address_id")
    private Address address;

    @Column(name = "ent_is_valid")
    private boolean isValid;
}
