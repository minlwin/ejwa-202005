package com.jdc.job.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.dto.JobOfferListDto;
import com.jdc.job.model.entity.JobOffer;
import com.jdc.job.model.entity.JobOffer.Status;
import com.jdc.job.model.service.JobOfferService;

@RestController
@RequestMapping("/public/jobs")
public class PublicJobOfferApi {

	@Autowired
	private JobOfferService service;

	@GetMapping
	public List<JobOfferListDto> search(
		@RequestParam(required = false) String jobType,
		@RequestParam(required = false) String location
			) {
		return service.search(jobType, location);
	}
	
	@GetMapping("{id}")
	public JobOffer findById(@PathVariable long id) {
		return service.findById(id);
	}

	@GetMapping("company/{id}/{status}")
	public List<JobOfferListDto> search(@PathVariable int id, @PathVariable Status status) {
		return service.searchForCompany(id, status);
	}
	
	
}
