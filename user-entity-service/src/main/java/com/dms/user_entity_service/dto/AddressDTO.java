package com.dms.user_entity_service.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private long id; // Primary key
    private String street;
    private String area;
    private String district;
    private String state;
    private String country;
    private String zipCode;
}