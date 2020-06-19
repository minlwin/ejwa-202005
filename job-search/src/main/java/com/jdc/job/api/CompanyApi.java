package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.BaseApi;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Company;
import com.jdc.job.model.service.CompanyService;

@RestController
@RequestMapping("companies")
public class CompanyApi extends BaseApi<Company, Integer>{
	
	@Autowired
	private CompanyService service;

	@Override
	protected BaseService<Company, Integer> service() {
		return service;
	}

}
