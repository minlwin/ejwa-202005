package com.jdc.job.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.entity.Address;
import com.jdc.job.model.repo.AddressRepo;

@Service
public class AddressService extends BaseService<Address, Integer>{

	@Autowired
	private AddressRepo repo;
	
	@Override
	protected BaseRepository<Address, Integer> repo() {
		return repo;
	}

	public List<Address> search(int division, int township, String address) {
		
		StringBuffer sb = new StringBuffer("select a from Address a where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(township != 0) {
			
			sb.append(" and a.township.id = :township");
			params.put("township", township);
			
		} else {
			if(division != 0) {
				sb.append(" and a.township.division.id = :division");
				params.put("division", division);
			}
		}
		
		if(!address.isEmpty()) {
			
			sb.append(" and (lower(a.street) like lower(:address) or lower(a.address) like lower(:address))");
			params.put("address", "%".concat(address).concat("%"));
		}
  		
		return repo.search(sb.toString(), params);
	}

}
