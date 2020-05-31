package com.jdc.market.api.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.sale.entity.SaleStatus;
import com.jdc.market.model.sale.service.SaleStatusService;

@RestController
@RequestMapping("sle/sale-statusus")
public class SaleStatusApi extends BaseApi<SaleStatus, Long>{

	@Autowired
	private SaleStatusService service;

	@Override
	protected BaseService<SaleStatus, Long> service() {
		return service;
	}
}
