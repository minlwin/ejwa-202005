package com.jdc.job.model;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{
	
	private EntityManager em;
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public List<T> search(String jpql, Map<String, Object> params) {
		return query(jpql, params, getDomainClass()).getResultList();
	}

	@Override
	public Long count(String jpql, Map<String, Object> params) {
		return query(jpql, params, Long.class).getSingleResult();
	}

	@Override
	public <D> List<D> search(String jpql, Map<String, Object> params, Class<D> type) {
		return query(jpql, params, type).getResultList();
	}
	
	private<D> TypedQuery<D> query(String jpql, Map<String, Object> params, Class<D> type) {
		TypedQuery<D> query = em.createQuery(jpql, type);
		
		if(null != params) {
			for(String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		
		return query;
	}

	@Override
	public <D> List<D> searchNamedQuery(String name, Map<String, Object> params, Class<D> type) {
		TypedQuery<D> query = em.createNamedQuery(name, type);
		if(null != params) {
			for(String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.getResultList();
	}

}
