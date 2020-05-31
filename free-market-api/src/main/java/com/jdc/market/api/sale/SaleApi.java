package com.jdc.market.api.sale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.sale.entity.Sale;
import com.jdc.market.model.sale.service.SaleService;

@RestController
@RequestMapping("sle/sales")
public class SaleApi extends BaseApi<Sale, Long> {

	private SaleService service;

	@Override
	protected BaseService<Sale, Long> service() {
		return service;
	}
}
