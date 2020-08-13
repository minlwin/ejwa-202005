package com.jdc.job.model.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.job.model.dto.JobOfferDto;
import com.jdc.job.model.dto.JobOfferListDto;
import com.jdc.job.model.entity.JobOffer;
import com.jdc.job.model.entity.JobOffer.Status;
import com.jdc.job.model.entity.JobOfferSummary;
import com.jdc.job.model.repo.JobOfferRepo;

@Service
public class JobOfferService {
	
	@Autowired
	private JobOfferRepo repo;
	
	@Autowired
	private CompanyService companies;

	public List<JobOfferListDto> search(String jobType, String location) {
		
		StringBuffer sb = new StringBuffer("select new com.jdc.job.model.dto.JobOfferListDto(j, 0) from JobOffer j where j.status = :status");
		Map<String, Object> params = new HashMap<>();
		
		params.put("status", Status.Published);
		
		if(!StringUtils.isEmpty(jobType)) {
			sb.append(" and lower(j.jobType) like lower(:jobType)");
			params.put("jobType", jobType.concat("%"));
		}
		
		if(!StringUtils.isEmpty(location)) {
			sb.append(" and lower(j.location) like lower(:location)");
			params.put("location", location.concat("%"));
		}

		return repo.search(sb.toString(), params, JobOfferListDto.class);
	}

	public List<JobOfferListDto> searchForCompany(int company, Status status) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("company", company);
		params.put("status", status);
		
		return repo.searchNamedQuery("JobOffer.findForCompany", params, JobOfferListDto.class);
	}

	public JobOffer findById(long id) {
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no job for this id."));
	}

	public JobOffer create(JobOfferDto dto) {
		JobOffer job = new JobOffer();
		setData(job, dto);
		return repo.save(job);
	}

	public JobOffer update(long id, JobOfferDto dto) {
		JobOffer job = repo.getOne(id);
		setData(job, dto);
		return repo.save(job);
	}

	private void setData(JobOffer job, JobOfferDto dto) {

		job.setCompany(companies.findById(dto.getCompany()));
		job.setDescriptions(dto.getDescriptions());
		job.setJobType(dto.getJobType());
		job.setLocation(dto.getLocation());

		if(job.getId() == 0) {
			job.setPostDate(LocalDate.now());
		}
		
		job.setStatus(dto.getStatus());
		
		JobOfferSummary summary = new JobOfferSummary();
		job.setSummary(summary);
		summary.setExpreiance(dto.getExpreiance());
		summary.setPosts(dto.getPosts());
		summary.setQualification(dto.getQualification());
		summary.setSalary(dto.getSalary());
		
		job.setTitle(dto.getTitle());
		
	}


}
