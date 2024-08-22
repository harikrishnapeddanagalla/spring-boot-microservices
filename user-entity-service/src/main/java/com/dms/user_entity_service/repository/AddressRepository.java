package com.dms.user_entity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.user_entity_service.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
