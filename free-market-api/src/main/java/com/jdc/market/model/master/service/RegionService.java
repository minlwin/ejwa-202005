package com.jdc.market.model.master.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Region;
import com.jdc.market.model.master.repo.RegionRepo;

@Service
public class RegionService extends BaseService<Region, Integer>{
	
	@Autowired
	private RegionRepo repo;

	@Override
	protected BaseRepository<Region, Integer> repo() {
		return repo;
	}

}
