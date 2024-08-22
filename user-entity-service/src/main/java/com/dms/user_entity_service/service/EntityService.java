package com.dms.user_entity_service.service;

import java.util.List;

import com.dms.user_entity_service.model.UEntity;

public interface EntityService {

	UEntity saveEntity(UEntity entity);
	
	List<UEntity> getAllEntities();

}
