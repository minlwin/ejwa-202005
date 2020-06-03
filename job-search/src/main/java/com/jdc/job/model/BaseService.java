package com.jdc.job.model;

import java.util.List;

import javax.persistence.EntityNotFoundException;

public abstract class BaseService<T, ID> {
	
	protected abstract BaseRepository<T, ID> repo();

	public List<T> findAll() {
		return repo().findAll();
	}
	
	public T findById(ID id) {
		return repo().findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public T save(T t) {
		return repo().save(t);
	}
}
