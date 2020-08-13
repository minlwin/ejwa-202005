package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.entity.Company;
import com.jdc.job.model.service.CompanyService;

@RestController
@RequestMapping("/public/companies")
public class PublicCompanyApi {

	@Autowired
	private CompanyService service;

	@GetMapping("{id}")
	public Company findById(@PathVariable int id) {
		return service.findById(id);
	}

	
}
