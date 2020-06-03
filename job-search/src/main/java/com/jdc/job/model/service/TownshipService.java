package com.jdc.job.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Township;
import com.jdc.job.model.repo.TownshipRepo;

@Service
public class TownshipService extends BaseService<Township, Integer>{

	@Autowired
	private TownshipRepo repo;
	
	@Override
	protected BaseRepository<Township, Integer> repo() {
		return repo;
	}

	public List<Township> findByDivisionId(int id) {
		return repo.findByDivisionId(id);
	}

}
