package com.jdc.market.model;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T extends BaseEntity<?>, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{
	
	private JpaEntityInformation<T, ID> entityInfo;
	private EntityManager em;

	public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
		this.entityInfo = entityInformation;
	}

}
