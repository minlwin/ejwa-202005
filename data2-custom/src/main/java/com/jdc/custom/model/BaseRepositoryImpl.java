package com.jdc.custom.model;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID> 
	extends SimpleJpaRepository<T, ID> 
	implements BaseRepository<T, ID>{
	
	private Class<T> domainClass;
	private EntityManager em;
	
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
		this.domainClass = entityInformation.getJavaType();
	}

	@Override
	public List<T> search(String jpql, Map<String, Object> params) {
		return query(jpql, params, domainClass).getResultList();
	}

	@Override
	public Long count(String jpql, Map<String, Object> params) {
		return query(jpql, params, Long.class).getSingleResult();
	}

	@Override
	public <D> List<D> search(String jpql, Map<String, Object> params, Class<D> type) {
		return query(jpql, params, type).getResultList();
	}
	
	private <R> TypedQuery<R> query(String jpql, Map<String, Object> params, Class<R> type) {
		
		TypedQuery<R> query = em.createQuery(jpql, type);
		
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query;
	}

}
