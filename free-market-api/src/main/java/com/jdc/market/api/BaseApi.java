package com.jdc.market.api;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseApi<T, ID extends Serializable> {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public T create(T t) {
		
		
		return t;
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public T update(T t) {
		
		return t;
	}
}
