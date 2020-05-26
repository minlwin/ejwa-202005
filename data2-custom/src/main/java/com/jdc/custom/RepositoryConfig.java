package com.jdc.custom;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.custom.model.BaseRepositoryImpl;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class RepositoryConfig {

}
