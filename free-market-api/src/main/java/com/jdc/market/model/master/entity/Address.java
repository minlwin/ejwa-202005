package com.jdc.market.model.master.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.market.model.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "MST_ADDRESS")
public class Address implements BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Township township;
	private String street;
	private String address;
	
	@ManyToOne
	private Member member;
}
