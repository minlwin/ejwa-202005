package com.jdc.example.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.example.model.entity.Region;
import com.jdc.example.model.repo.RegionRepo;

@Service
public class RegionService {

	@Autowired
	private RegionRepo repo;
	
	public Optional<Region> findByCapital(String capital) {
		
		if(StringUtils.isEmpty(capital)) {
			return Optional.empty();
		}
		
		Region r  = Region.withCapital(capital);
		
		return repo.findOne(Example.of(r, ExampleMatcher.matching()
				.withIgnoreNullValues()
				.withMatcher("capital", m -> m.ignoreCase())));
	}
	
	public List<Region> search(String name, String capital, String region) {
		
		Region r = new Region();
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnoreNullValues()
				.withIgnorePaths("id", "townships");
		
		if(!StringUtils.isEmpty(name)) {
			r.setName(name);
			matcher = matcher.withMatcher("name", m -> m.ignoreCase().startsWith());
		}
		
		if(!StringUtils.isEmpty(capital)) {
			r.setCapital(capital);
			matcher = matcher.withMatcher("capital", m -> m.ignoreCase().startsWith());
		}

		if(!StringUtils.isEmpty(region)) {
			r.setRegion(region);
			matcher = matcher.withMatcher("region", m -> m.ignoreCase().startsWith());
		}

		return repo.findAll(Example.of(r, matcher));
	}
}
