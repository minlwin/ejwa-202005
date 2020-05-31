package com.jdc.market.api.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Category;
import com.jdc.market.model.master.service.CategoryService;

@RestController
@RequestMapping("mst/categories")
public class CategoryApi extends BaseApi<Category, Integer>{

	@Autowired
	private CategoryService service;

	@Override
	protected BaseService<Category, Integer> service() {
		return service;
	}
}
