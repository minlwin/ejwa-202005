package com.jdc.custom.model.dto;

import lombok.Data;

@Data
public class ItemDTO {

	private int id;
	private String category;
	private String brend;
	private String item;
	private int price;
	
	public ItemDTO(int id, String category, String brend, String item, int price) {
		super();
		this.id = id;
		this.category = category;
		this.brend = brend;
		this.item = item;
		this.price = price;
	}
	

	
}
