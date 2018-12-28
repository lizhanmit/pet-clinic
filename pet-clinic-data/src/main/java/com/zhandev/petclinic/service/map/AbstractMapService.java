package com.zhandev.petclinic.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.zhandev.petclinic.model.BaseEntity;


public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T object) {
		
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
			
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object cannot be null.");
		}
		
		return object;
	}
	
	private Long getNextId() {
		Long maxId = null;
		
		try {
			maxId = Collections.max(map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			maxId = 1L;
		}
		return maxId;
	}

	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
}
