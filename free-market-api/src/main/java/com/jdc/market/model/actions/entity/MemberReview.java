package com.jdc.market.model.actions.entity;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.market.model.master.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "REP_REVIEW_MEMBER")
public class MemberReview extends AbstractReview{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Member member;

}
