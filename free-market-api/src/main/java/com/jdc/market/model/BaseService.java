package com.jdc.market.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

public abstract class BaseService<T extends BaseEntity<?>, ID extends Serializable> {
	
	protected abstract BaseRepository<T, ID> repo();
	
	@Transactional
	public void save(T t) {
		repo().save(t);
	}
	
	public List<T> getAll() {
		return repo().findAll();
	}

	public Optional<T> findById(ID id) {
		return repo().findById(id);
	}

}
