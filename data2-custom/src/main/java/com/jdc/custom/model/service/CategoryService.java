package com.jdc.custom.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.custom.model.entity.Category;
import com.jdc.custom.model.repo.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo repo;

	@Transactional
	public List<Category> getChild(String name) {
		List<Category> result = new ArrayList<>();
		
		Category c = repo.findOneByName(name);
		
		if(null != c) {
			setChilds(c, result);
		}
		
		return result;
	}
	
	private void setChilds(Category c, List<Category> list) {
		
		for(Category  child : c.getChildren()) {
			setChilds(child, list);
		}
		
		list.add(c);
		
	}
	

}
