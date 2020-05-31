package com.jdc.market.api.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.MemberReview;
import com.jdc.market.model.actions.service.MemberReviewService;

@RestController
@RequestMapping("act/review/members")
public class MemberReviewApi extends BaseApi<MemberReview, Long>{
	
	@Autowired
	private MemberReviewService service;

	@Override
	protected BaseService<MemberReview, Long> service() {
		return service;
	}

}
