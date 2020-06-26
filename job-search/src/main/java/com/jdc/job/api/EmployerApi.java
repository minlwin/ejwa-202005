package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.BaseApi;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Employer;
import com.jdc.job.model.service.EmployerService;


@RestController
@RequestMapping("employers")
public class EmployerApi extends BaseApi<Employer, String>{
	
	@Autowired
	private EmployerService service;
	

	@Override
	protected BaseService<Employer, String> service() {
		return service;
	}
	
	@PostMapping
	public Employer create(@RequestBody Employer emp) {
		return service.create(emp);
	}
	
	@PutMapping
	public Employer update(@RequestBody Employer emp) {
		return service.save(emp);
	}

}
