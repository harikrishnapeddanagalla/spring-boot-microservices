package com.dms.user_entity_service.dto;

import lombok.Data;

@Data
public class EntityDTO {
    private long entRid;
    private String entCode;
    private String entName;
    private String entType;
    private boolean isValid;
    private AddressDTO address;  
}
