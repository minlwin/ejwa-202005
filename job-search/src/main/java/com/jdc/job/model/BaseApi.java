package com.jdc.job.model;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseApi<T, ID> {

	protected abstract BaseService<T, ID>  service();
	
	@GetMapping
	public List<T> findAll() {
		return service().findAll();
	}
	
	@GetMapping("{id}")
	public T findById(@PathVariable ID id) {
		return service().findById(id);
	}
	
	@PostMapping
	public T create(@RequestBody T t) {
		return service().save(t);
	}
	
	@PutMapping
	public T update(@RequestBody T  t) {
		return service().save(t);
	}
	
}
