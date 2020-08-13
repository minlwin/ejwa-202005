package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.dto.JobOfferDto;
import com.jdc.job.model.entity.JobOffer;
import com.jdc.job.model.service.JobOfferService;

@RestController
@RequestMapping("jobs")
public class JobOfferApi {
	
	@Autowired
	private JobOfferService service;

	
	@PostMapping
	public JobOffer create(@RequestBody JobOfferDto dto) {
		return service.create(dto);
	}
	
	@PutMapping("{id}")
	public JobOffer update(@PathVariable long id, @RequestBody JobOfferDto dto) {
		return service.update(id, dto);
	}
}
