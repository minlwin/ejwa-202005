package com.jdc.job.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Company;
import com.jdc.job.model.repo.CompanyRepo;

@Service
public class CompanyService extends BaseService<Company, Integer>{
	
	@Autowired
	private CompanyRepo repo;

	@Override
	protected BaseRepository<Company, Integer> repo() {
		return repo;
	}

}
