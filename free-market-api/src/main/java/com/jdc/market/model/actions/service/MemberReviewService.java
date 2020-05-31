package com.jdc.market.model.actions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.MemberReview;
import com.jdc.market.model.actions.reppo.MemberReviewRepo;

@Service
public class MemberReviewService extends BaseService<MemberReview, Long>{

	@Autowired
	private MemberReviewRepo repo;

	@Override
	protected BaseRepository<MemberReview, Long> repo() {
		return repo;
	}
}
