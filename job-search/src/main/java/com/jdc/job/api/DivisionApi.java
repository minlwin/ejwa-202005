package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.BaseApi;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Division;
import com.jdc.job.model.service.DivisionService;

@RestController
@RequestMapping("divisions")
public class DivisionApi extends BaseApi<Division, Integer> {
	
	@Autowired
	private DivisionService service;

	@Override
	protected BaseService<Division, Integer> service() {
		return service;
	}

}
