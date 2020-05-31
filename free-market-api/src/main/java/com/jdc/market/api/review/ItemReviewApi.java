package com.jdc.market.api.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.ItemReview;
import com.jdc.market.model.actions.service.ItemReviewService;

@RestController
@RequestMapping("act/review/items")
public class ItemReviewApi extends BaseApi<ItemReview, Long>{

	@Autowired
	private ItemReviewService service;

	@Override
	protected BaseService<ItemReview, Long> service() {
		return service;
	}
}
