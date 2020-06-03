package com.jdc.job.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.job.model.BaseRepositoryImpl;

@Configuration
@EnableJpaRepositories(
		basePackages = {"com.jdc.job.model.repo"},
		repositoryBaseClass = BaseRepositoryImpl.class
)
public class RepositoryConfig {

}
