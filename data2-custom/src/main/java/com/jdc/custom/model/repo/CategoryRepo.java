package com.jdc.custom.model.repo;

import com.jdc.custom.model.BaseRepository;
import com.jdc.custom.model.entity.Category;

public interface CategoryRepo extends BaseRepository<Category, Integer> {
	
	Category findOneByName(String name);

}
