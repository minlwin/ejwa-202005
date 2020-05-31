package com.jdc.market.model.master.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.master.entity.Member;
import com.jdc.market.model.master.repo.MemberRepo;

@Service
public class MemberService extends BaseService<Member, String>{

	@Autowired
	private MemberRepo repo;

	@Override
	protected BaseRepository<Member, String> repo() {
		return repo;
	}
}
