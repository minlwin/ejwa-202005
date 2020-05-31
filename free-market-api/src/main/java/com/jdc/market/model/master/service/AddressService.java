package com.jdc.market.model.master.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Address;
import com.jdc.market.model.master.repo.AddressRepo;

@Service
public class AddressService extends BaseService<Address, Long>{

	@Autowired
	private AddressRepo repo;
	
	@Override
	protected BaseRepository<Address, Long> repo() {
		return repo;
	}

}
