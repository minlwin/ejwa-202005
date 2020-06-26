package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.BaseApi;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Profile;
import com.jdc.job.model.service.ProfileService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("profiles")
public class ProfileApi extends BaseApi<Profile, Integer> {
	
	@Autowired
	private ProfileService service;

	@Override
	protected BaseService<Profile, Integer> service() {
		return service;
	}
	
	@PostMapping("{login}")
	public Profile create(@PathVariable String login, @RequestBody Profile profile) {
		return service.save(login, profile);
	}

	@PutMapping("{login}")
	public Profile update(@PathVariable String login, @RequestBody Profile profile) {
		return service.save(login, profile);
	}
}
