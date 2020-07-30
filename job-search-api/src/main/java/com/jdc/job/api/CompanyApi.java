package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.dto.CompanyDto;
import com.jdc.job.model.entity.Company;
import com.jdc.job.model.service.CompanyService;

@RestController
@RequestMapping("companies")
public class CompanyApi {
	
	@Autowired
	private CompanyService service;

	@GetMapping("{id}")
	public Company findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Company create(@RequestBody CompanyDto dto) {
		return service.create(dto);
	}
	
	@PutMapping("{id}")
	public Company update(@PathVariable int id, @RequestBody CompanyDto dto) {
		return service.save(id, dto);
	}
	
	@PostMapping("{id}/photo")
	public Company uploadPhoto() {
		return null;
	}
}
