package com.jdc.job.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.BaseApi;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Township;
import com.jdc.job.model.service.TownshipService;

@RestController
@RequestMapping("townships")
public class TownshipApi extends BaseApi<Township, Integer>{

	@Autowired
	private TownshipService service;

	@Override
	protected BaseService<Township, Integer> service() {
		return service;
	}
	
	@GetMapping("division/{id}")
	public List<Township> findByDivision(@PathVariable int id) {
		return service.findByDivisionId(id);
	}

}
