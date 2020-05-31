package com.jdc.market.api.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.sale.entity.Item;
import com.jdc.market.model.sale.service.ItemService;

@RestController
@RequestMapping("sle/items")
public class ItemApi extends BaseApi<Item, Long>{

	@Autowired
	private ItemService service;

	@Override
	protected BaseService<Item, Long> service() {
		return service;
	}
}
