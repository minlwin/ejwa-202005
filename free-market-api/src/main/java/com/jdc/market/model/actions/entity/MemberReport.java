package com.jdc.market.model.actions.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.market.model.master.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "REP_REPORT_MEMBER")
public class MemberReport extends AbstractReport{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Member member;

}
