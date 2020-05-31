package com.jdc.market.model.sale.service;

import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.sale.entity.Image;
import com.jdc.market.model.sale.repo.ImageRepo;

@Service
public class ImageService extends BaseService<Image, Long> {
	
	private ImageRepo repo;

	@Override
	protected BaseRepository<Image, Long> repo() {
		return repo;
	}
}
