package com.jdc.market.model.actions.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.market.model.BaseEntity;
import com.jdc.market.model.master.entity.Member;
import com.jdc.market.model.master.entity.SecurityInfo;

import lombok.Data;

@Data
@Entity
@Table(name = "ACT_REVIEW")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractReview implements BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int rating;
	
	@ManyToOne
	private Member reviewer;
	private String review;
	
	@Embedded
	private SecurityInfo security;

}
