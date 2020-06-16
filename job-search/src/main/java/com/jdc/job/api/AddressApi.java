package com.jdc.job.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.BaseApi;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Address;
import com.jdc.job.model.service.AddressService;

@RestController
@RequestMapping("addresses")
public class AddressApi extends BaseApi<Address, Integer>{
	
	@Autowired
	private AddressService service;

	@Override
	protected BaseService<Address, Integer> service() {
		return service;
	}
	
	@GetMapping("search")
	public List<Address> search(
			@RequestParam(defaultValue = "0") int division, 
			@RequestParam(defaultValue = "0") int township, 
			@RequestParam(defaultValue = "") String address) {
		return service.search(division, township, address);
	}

}
