package com.jdc.job.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.dto.JobOfferDto;
import com.jdc.job.model.dto.JobOfferListDto;
import com.jdc.job.model.entity.JobOffer;
import com.jdc.job.model.service.JobOfferService;

@RestController
@RequestMapping("jobs")
public class JobOfferApi {
	
	@Autowired
	private JobOfferService service;

	@GetMapping
	public List<JobOfferListDto> search(
		@RequestParam(required = false) String jobType,
		@RequestParam(required = false) String location
			) {
		return service.search(jobType, location);
	}
	
	@GetMapping("company/{id}")
	public List<JobOfferListDto> search(int id) {
		return service.searchForCompany(id);
	}
	
	
	@GetMapping("{id}")
	public JobOffer findById(@PathVariable long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public JobOffer create(@RequestBody JobOfferDto dto) {
		return service.create(dto);
	}
	
	@PutMapping("{id}")
	public JobOffer update(@PathVariable long id, @RequestBody JobOfferDto dto) {
		return service.update(id, dto);
	}
}
