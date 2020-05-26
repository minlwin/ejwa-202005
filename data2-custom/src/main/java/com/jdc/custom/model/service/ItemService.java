package com.jdc.custom.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.custom.model.entity.Item;
import com.jdc.custom.model.entity.Item.State;
import com.jdc.custom.model.repo.ItemRepo;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepo itemRepo;

	public List<Item> search(String name, String brend, State state, int priceFrom, int priceTo) {
		
		StringBuffer sb = new StringBuffer("select i from Item i where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(!StringUtils.isEmpty(name)) {
			sb.append(" and lower(i.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}
		
		if(!StringUtils.isEmpty(brend)) {
			sb.append(" and i.brend = :brend");
			params.put("brend", brend);
		}
		
		if(null != state) {
			sb.append(" and i.state = :state");
			params.put("state", state);
		}
		
		if(priceFrom > 0) {
			sb.append(" and i.price >= :from");
			params.put("from", priceFrom);
		}
		
		if(priceTo > 0 && priceTo > priceFrom) {
			sb.append(" and i.price <= :to");
			params.put("to", priceTo);
		}

		return itemRepo.search(sb.toString(), params);
	}
}
