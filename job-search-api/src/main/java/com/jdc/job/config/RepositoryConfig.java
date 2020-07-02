package com.jdc.job.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.job.model.BaseRepositoryImpl;
import com.jdc.job.model.dto.SignUpDto;
import com.jdc.job.model.entity.Account.Role;
import com.jdc.job.model.service.AccountService;

@Configuration
@EnableJpaRepositories(
		basePackages = {"com.jdc.job.model.repo"},
		repositoryBaseClass = BaseRepositoryImpl.class
)
public class RepositoryConfig {
	
	@Autowired
	private AccountService service;

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			if(service.count() == 0) {
				SignUpDto admin = new SignUpDto();
				admin.setEmail("Admin");
				admin.setPassword("Admin");
				admin.setRole(Role.Admin);
				admin.setName("Admin User");
				
				service.signUp(admin);
			}
		};
	}
}
