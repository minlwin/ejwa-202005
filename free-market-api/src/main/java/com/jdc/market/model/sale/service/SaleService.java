package com.jdc.market.model.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.sale.entity.Sale;
import com.jdc.market.model.sale.repo.SaleRepo;

@Service
public class SaleService extends BaseService<Sale, Long>{
	
	@Autowired
	private SaleRepo repo;

	@Override
	protected BaseRepository<Sale, Long> repo() {
		return repo;
	}

}
