package com.jdc.market.api.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Member;
import com.jdc.market.model.master.service.MemberService;

@RestController
@RequestMapping("mst/members")
public class MemberApi extends BaseApi<Member, String>{
	
	@Autowired
	private MemberService service;

	@Override
	protected BaseService<Member, String> service() {
		return service;
	}

}
