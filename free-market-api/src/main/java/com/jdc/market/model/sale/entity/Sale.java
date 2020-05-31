package com.jdc.market.model.sale.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.market.model.BaseEntity;
import com.jdc.market.model.master.entity.Address;
import com.jdc.market.model.master.entity.Member;
import com.jdc.market.model.master.entity.SecurityInfo;

import lombok.Data;

@Data
@Entity
@Table(name = "SLE_SALE")
public class Sale implements BaseEntity<Long>{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Member customer;
	
	@ManyToOne
	private Address deleverTo;
	
	private int salePrice;
	private int delevery;
	
	@Embedded
	private SecurityInfo security = new SecurityInfo();

}
