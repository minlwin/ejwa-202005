package com.jdc.job.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Division;
import com.jdc.job.model.repo.DivisionRepo;

@Service
public class DivisionService extends BaseService<Division, Integer>{
	
	@Autowired
	private DivisionRepo repo;

	@Override
	protected BaseRepository<Division, Integer> repo() {
		return repo;
	}

}
