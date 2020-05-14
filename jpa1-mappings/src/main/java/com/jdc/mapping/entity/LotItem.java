package com.jdc.mapping.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LotItem extends Item{

	private int quantity;
	private int unitPrice;

}
