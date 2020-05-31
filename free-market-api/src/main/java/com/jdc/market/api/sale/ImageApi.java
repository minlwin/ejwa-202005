package com.jdc.market.api.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.sale.entity.Image;
import com.jdc.market.model.sale.service.ImageService;

@RestController
@RequestMapping("sle/images")
public class ImageApi extends BaseApi<Image, Long>{

	@Autowired
	private ImageService service;

	@Override
	protected BaseService<Image, Long> service() {
		return service;
	}
}
