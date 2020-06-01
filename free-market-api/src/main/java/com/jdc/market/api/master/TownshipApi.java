package com.jdc.market.api.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Township;
import com.jdc.market.model.master.service.TownshipService;

@RestController
@RequestMapping("mst/townships")
public class TownshipApi extends BaseApi<Township, Integer>{

	@Autowired
	private TownshipService service;

	@Override
	protected BaseService<Township, Integer> service() {
		return service;
	}
	
	@GetMapping("region/{id}")
	public List<Township> findByRegion(int regionId) {
		return service.findByRegion(regionId);
	}
	
}
