package com.dms.user_entity_service.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.user_entity_service.dto.EntityDTO;
import com.dms.user_entity_service.model.UEntity;
import com.dms.user_entity_service.service.EntityService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class EntityController {
	
	private static final Logger logger = LoggerFactory.getLogger(EntityController.class);
	
	@Autowired
	private EntityService entityService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/saveEntity")
    public ResponseEntity<EntityDTO> createEntity(@RequestBody EntityDTO entityDTO) {
        UEntity entity = modelMapper.map(entityDTO, UEntity.class);
        UEntity savedEntity = entityService.saveEntity(entity);
        EntityDTO responseDTO = modelMapper.map(savedEntity, EntityDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
	
	
	@GetMapping("/getAllEntities")
	public List<EntityDTO> getAllEntities () {
		
		List<UEntity> entities = entityService.getAllEntities();
		
		List<EntityDTO> allEntities = entities.stream()
		.map(entity -> modelMapper.map(entity, EntityDTO.class))
		.collect(Collectors.toList());
		
		return allEntities;
		
		
	}
}
