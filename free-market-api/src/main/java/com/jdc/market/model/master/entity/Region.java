package com.jdc.market.model.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jdc.market.model.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "MST_REGION")
public class Region implements BaseEntity<Integer>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String name;
	
	private String capital;
	
	private String region;
}
