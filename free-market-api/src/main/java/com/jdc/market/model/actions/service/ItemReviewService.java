package com.jdc.market.model.actions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.ItemReview;
import com.jdc.market.model.actions.reppo.ItemReviewRepo;

@Service
public class ItemReviewService extends BaseService<ItemReview, Long> {

	@Autowired
	private ItemReviewRepo repo;

	@Override
	protected BaseRepository<ItemReview, Long> repo() {
		return repo;
	}
}
