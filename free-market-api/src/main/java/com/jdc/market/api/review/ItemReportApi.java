package com.jdc.market.api.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.ItemReport;
import com.jdc.market.model.actions.service.ItemReportService;

@RestController
@RequestMapping("act/report/items")
public class ItemReportApi extends BaseApi<ItemReport, Long>{
	
	@Autowired
	private ItemReportService service;

	@Override
	protected BaseService<ItemReport, Long> service() {
		return service;
	}

}
