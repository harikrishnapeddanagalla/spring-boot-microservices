package com.dms.user_entity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dms.user_entity_service.model.UEntity;

@Repository
public interface EntityRepository extends JpaRepository<UEntity, Long>{

}
