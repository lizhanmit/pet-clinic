package com.zhandev.petclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.zhandev.petclinic.model.Owner;
import com.zhandev.petclinic.model.Specialty;
import com.zhandev.petclinic.service.OwnerService;
import com.zhandev.petclinic.service.SpecialtyService;

@Service
public class SecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

	@Override
	public Set<Specialty> findAll() {
		return super.findAll();
	}
	
	@Override
	public Specialty findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Specialty save(Specialty object) {
		return super.save(object);
	}

	@Override
	public void delete(Specialty object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
