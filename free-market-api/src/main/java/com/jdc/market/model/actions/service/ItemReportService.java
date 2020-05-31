package com.jdc.market.model.actions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.ItemReport;
import com.jdc.market.model.actions.reppo.ItemReportRepo;

@Service
public class ItemReportService extends BaseService<ItemReport, Long>{
	
	@Autowired
	private ItemReportRepo repo;

	@Override
	protected BaseRepository<ItemReport, Long> repo() {
		return repo;
	}

}
