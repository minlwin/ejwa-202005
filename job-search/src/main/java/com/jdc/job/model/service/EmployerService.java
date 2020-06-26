package com.jdc.job.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.JobSearchException;
import com.jdc.job.model.entity.Employer;
import com.jdc.job.model.repo.EmployeerRepo;

@Service
public class EmployerService extends BaseService<Employer, String>{

	@Autowired
	private EmployeerRepo repo;
	
	@Override
	protected BaseRepository<Employer, String> repo() {
		return repo;
	}
	
	public Employer create(Employer emp) {
		
		// check login id
		JobSearchException ex = repo.findById(emp.getLogin())
			.map(a -> new JobSearchException(String.format("Your email (%s) has already registered.", emp.getLogin())))
			.orElse(null);
		
		if(ex != null) {
			throw ex;
		}
		
		return repo.save(emp);
	}
}
