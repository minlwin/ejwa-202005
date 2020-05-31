package com.jdc.market.model.master.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Category;
import com.jdc.market.model.master.repo.CategoryRepo;

@Service
public class CategoryService extends BaseService<Category, Integer>{
	
	@Autowired
	private CategoryRepo repo;

	@Override
	protected BaseRepository<Category, Integer> repo() {
		return repo;
	}

}
