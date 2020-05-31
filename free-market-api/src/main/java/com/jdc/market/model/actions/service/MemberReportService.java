package com.jdc.market.model.actions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.MemberReport;
import com.jdc.market.model.actions.reppo.MemberReportRepo;

@Service
public class MemberReportService extends BaseService<MemberReport, Long>{

	@Autowired
	private MemberReportRepo repo;

	@Override
	protected BaseRepository<MemberReport, Long> repo() {
		return repo;
	}
}
