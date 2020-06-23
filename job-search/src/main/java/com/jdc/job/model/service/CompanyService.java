package com.jdc.job.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Company;
import com.jdc.job.model.repo.CompanyRepo;

@Service
public class CompanyService extends BaseService<Company, Integer>{
	
	@Autowired
	private CompanyRepo repo;

	@Override
	protected BaseRepository<Company, Integer> repo() {
		return repo;
	}

	public List<String> getCategories() {
		String jpql = "select distinct c.category from Company c order by c.category";
		return repo.search(jpql, new HashMap<>(), String.class);
	}

	public List<Company> search(String category, String name) {
		
		StringBuffer sb = new StringBuffer("select c from Company c where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(!StringUtils.isEmpty(category)) {
			sb.append(" and c.category = :category");
			params.put("category", category);
		}
		
		if(!StringUtils.isEmpty(name)) {
			sb.append(" and lower(c.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}		

		return repo.search(sb.toString(), params);
	}

}
