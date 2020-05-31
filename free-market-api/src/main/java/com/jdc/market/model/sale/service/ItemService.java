package com.jdc.market.model.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.sale.entity.Item;
import com.jdc.market.model.sale.repo.ItemRepo;

@Service
public class ItemService extends BaseService<Item, Long>{

	@Autowired
	private ItemRepo repo;

	@Override
	protected BaseRepository<Item, Long> repo() {
		return repo;
	}
	
}
