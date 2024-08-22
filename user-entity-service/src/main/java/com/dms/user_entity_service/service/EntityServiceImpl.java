package com.dms.user_entity_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.user_entity_service.model.Address;
import com.dms.user_entity_service.model.UEntity;
import com.dms.user_entity_service.repository.AddressRepository;
import com.dms.user_entity_service.repository.EntityRepository;



@Service
public class EntityServiceImpl implements EntityService{

	@Autowired
	private EntityRepository entityRepo;
	
	@Autowired
    private AddressRepository addressRepository;
	
	@Override
	public UEntity saveEntity(UEntity entity) {
		
		Address savedAddress = addressRepository.save(entity.getAddress());
		entity.setAddress(savedAddress);
		return entityRepo.save(entity);
	}

	@Override
	public List<UEntity> getAllEntities() {
	
		List<UEntity> allEntities = entityRepo.findAll();
		return allEntities;
	}
	
	

}
