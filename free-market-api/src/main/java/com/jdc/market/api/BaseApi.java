package com.jdc.market.api;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jdc.market.model.BaseEntity;
import com.jdc.market.model.BaseService;

public abstract class BaseApi<T extends BaseEntity<?>, ID extends Serializable> {
	
	protected abstract BaseService<T, ID> service();

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public T create(T t) {
		service().save(t);
		return t;
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public T update(T t) {
		service().save(t);
		return t;
	}
}
