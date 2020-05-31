package com.jdc.market.api.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Address;
import com.jdc.market.model.master.service.AddressService;

@RestController
@RequestMapping("mst/addresses")
public class AddressApi extends BaseApi<Address, Long>{
	
	@Autowired
	private AddressService service;

	@Override
	protected BaseService<Address, Long> service() {
		return service;
	}

}
