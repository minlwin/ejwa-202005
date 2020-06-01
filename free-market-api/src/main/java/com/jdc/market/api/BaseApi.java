package com.jdc.market.api;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jdc.market.model.BaseEntity;
import com.jdc.market.model.BaseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public abstract class BaseApi<T extends BaseEntity<?>, ID extends Serializable> {
	
	protected abstract BaseService<T, ID> service();

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public T create(@RequestBody T t) {
		service().save(t);
		return t;
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public T update(@RequestBody T t) {
		service().save(t);
		return t;
	}
	
	@GetMapping
	public List<T> getAll() {
		return service().getAll();
	}
	
	@GetMapping("{id}")
	public T findById(@PathVariable ID id) {
		return service().findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
}
