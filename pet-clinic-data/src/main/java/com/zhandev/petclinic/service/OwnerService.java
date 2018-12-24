package com.zhandev.petclinic.service;

import java.util.Set;

import com.zhandev.petclinic.model.Owner;

public interface OwnerService {

	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll(); 
}
