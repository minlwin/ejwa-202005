package com.jdc.job.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.job.model.dto.JobOfferDto;
import com.jdc.job.model.dto.JobOfferListDto;
import com.jdc.job.model.entity.Account;
import com.jdc.job.model.entity.Company;
import com.jdc.job.model.entity.JobOffer;
import com.jdc.job.model.entity.JobOffer.Status;
import com.jdc.job.model.repo.JobOfferRepo;

@Service
public class JobOfferService {
	
	@Autowired
	private JobOfferRepo repo;
	
	@Autowired
	private AccountService accounts;
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

	public List<JobOfferListDto> searchForCompany(int company) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("company", company);
		
		Account loginUser = accounts.getLoginUser();
		Company comp = companies.findById(company);
		
		if(comp.getOwner().getEmail().equals(loginUser.getEmail())) {
			params.put("status", Arrays.asList(Status.values()));
		} else {
			params.put("status", Arrays.asList(Status.Published, Status.Finish));
		}

		return repo.searchNamedQuery("JobOffer.findForCompany", null, JobOfferListDto.class);
	}

	public JobOffer findById(long id) {
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no job for this id."));
	}

	public JobOffer create(JobOfferDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public JobOffer update(long id, JobOfferDto dto) {
		// TODO Auto-generated method stub
		return null;
	}


}
