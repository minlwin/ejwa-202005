package com.jdc.example.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.example.model.entity.Region;
import com.jdc.example.model.entity.Township;
import com.jdc.example.model.repo.TownshipRepo;

@Service
public class TownshipService {

	@Autowired
	private TownshipRepo repo;
	
	public List<Township> search(String regionName, String region, String name) {
		
		Township tsh = new Township();
		Region r = new Region();
		
		ExampleMatcher matcher = ExampleMatcher.matching(
				).withIgnoreNullValues();
		
		
		if(!StringUtils.isEmpty(regionName)) {
			r.setName(regionName);
			tsh.setRegion(r);
			matcher = matcher.withMatcher("region.name", m -> m.ignoreCase().startsWith());
		}
		
		if(!StringUtils.isEmpty(region)) {
			r.setRegion(region);
			tsh.setRegion(r);
			matcher = matcher.withMatcher("region.region", m -> m.ignoreCase());
		}
		
		if(!StringUtils.isEmpty(region)) {
			tsh.setName(name);
			matcher = matcher.withMatcher("name", m -> m.ignoreCase());
		}
		
		return repo.findAll(Example.of(tsh, matcher));
	}
}
