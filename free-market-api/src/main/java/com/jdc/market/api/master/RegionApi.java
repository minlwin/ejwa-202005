package com.jdc.market.api.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Region;
import com.jdc.market.model.master.service.RegionService;

@RestController
@RequestMapping("mst/regions")
public class RegionApi extends BaseApi<Region, Integer>{

	@Autowired
	private RegionService service;
	
	@Override
	protected BaseService<Region, Integer> service() {
		return service;
	}	
}
