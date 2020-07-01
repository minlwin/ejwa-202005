package com.jdc.job.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.job.model.dto.SignUpDto;
import com.jdc.job.model.service.MemberService;

@Configuration
public class AdminUserInitializer {

	@Autowired
	private MemberService service;
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			if(service.count() == 0) {
				
				SignUpDto dto = new SignUpDto();
				dto.setEmail("admin");
				dto.setPassword("admin");
				dto.setRole("Admin");
				dto.setName("Admin User");
				service.signUp(dto);
			}
		};
	}
}
