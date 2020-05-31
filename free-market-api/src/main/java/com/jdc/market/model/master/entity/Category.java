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
@Table(name = "MST_CATEGORY")
public class Category implements BaseEntity<Integer>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@ManyToOne
	private Category category;
}
