package com.jdc.job.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Address;
import com.jdc.job.model.repo.AddressRepo;

@Service
public class AddressService extends BaseService<Address, Integer>{

	@Autowired
	private AddressRepo repo;
	
	@Override
	protected BaseRepository<Address, Integer> repo() {
		return repo;
	}

}
