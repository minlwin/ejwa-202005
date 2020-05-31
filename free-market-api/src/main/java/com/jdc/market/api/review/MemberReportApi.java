package com.jdc.market.api.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.MemberReport;
import com.jdc.market.model.actions.service.MemberReportService;

@RestController
@RequestMapping("act/report/members")
public class MemberReportApi extends BaseApi<MemberReport, Long>{
	
	@Autowired
	private MemberReportService service;

	@Override
	protected BaseService<MemberReport, Long> service() {
		return service;
	}
}
