package com.jdc.market.model.sale.entity;

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
@Table(name = "SLE_IMAGE")
public class Image implements BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String url;
	private String description;
	
	private boolean cover;
	
	@ManyToOne
	private Item item;
}
