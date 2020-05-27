package com.jdc.custom.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.custom.model.dto.ItemDTO;
import com.jdc.custom.model.entity.Category;
import com.jdc.custom.model.entity.Item;
import com.jdc.custom.model.entity.Item.State;
import com.jdc.custom.model.repo.ItemRepo;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private CategoryService catService;

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
	
	public List<ItemDTO> searchForList(String category, String brend, String name) {
		
		StringBuffer sb = new StringBuffer("select new com.jdc.custom.model.dto.ItemDTO"
				+ "(i.id, i.category.name, i.brend, i.name, i.price) "
				+ "from Item i where 1 = 1");
		
		Map<String, Object> params = new HashMap<>();
		
		if(!StringUtils.isEmpty(category)) {
			
			List<Category> categories = catService.getChild(category);
			
			sb.append(" and i.category.id in :cIds");
			params.put("cIds", categories.stream().map(c -> c.getId()).collect(Collectors.toList()));
			
		}
		
		if(!StringUtils.isEmpty(brend)) {
			sb.append(" and i.brend = :brend");
			params.put("brend", brend);
		}
		
		if(!StringUtils.isEmpty(name)) {
			sb.append(" and lower(i.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}
		
		
		return itemRepo.search(sb.toString(), params, ItemDTO.class);
	}
}
