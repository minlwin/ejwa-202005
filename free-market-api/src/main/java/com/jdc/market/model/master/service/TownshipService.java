package com.jdc.market.model.master.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Township;
import com.jdc.market.model.master.repo.TownshipRepo;

@Service
public class TownshipService extends BaseService<Township, Integer>{

	@Autowired
	private TownshipRepo repo;

	@Override
	protected BaseRepository<Township, Integer> repo() {
		return repo;
	}

	public List<Township> findByRegion(int regionId) {
		return repo.findByRegionId(regionId);
	}
}
