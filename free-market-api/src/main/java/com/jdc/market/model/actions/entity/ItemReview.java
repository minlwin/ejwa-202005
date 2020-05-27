package com.jdc.market.model.actions.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.market.model.sale.entity.Item;

@Entity
@Table(name = "REP_REVIEW_ITEM")
public class ItemReview extends AbstractReview{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Item item;
	
}
