package com.jdc.mapping.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SingleItem extends Item{

	private int price;
}
