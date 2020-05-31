package com.jdc.market.model.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.sale.entity.SaleStatus;
import com.jdc.market.model.sale.repo.SaleStatusRepo;

@Service
public class SaleStatusService extends BaseService<SaleStatus, Long>{

	@Autowired
	private SaleStatusRepo repo;

	@Override
	protected BaseRepository<SaleStatus, Long> repo() {
		return repo;
	}
}
