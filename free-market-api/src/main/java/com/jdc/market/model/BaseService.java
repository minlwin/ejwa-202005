package com.jdc.market.model;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

public abstract class BaseService<T extends BaseEntity<?>, ID extends Serializable> {
	
	protected abstract BaseRepository<T, ID> repo();
	
	@Transactional
	public void save(T t) {
		repo().save(t);
	}

}
