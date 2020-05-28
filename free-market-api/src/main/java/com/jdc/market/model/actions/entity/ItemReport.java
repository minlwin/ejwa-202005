package com.jdc.market.model.actions.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.market.model.sale.entity.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ACT_REPORT_ITEM")
public class ItemReport extends AbstractReport{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Item item;
}
