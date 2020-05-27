package com.jdc.custom.model.dto;

public interface ItemSummary {

	String getName();
	int getPrice();
	CategorySummary getCategory();
	
	interface CategorySummary {
		String getName();
	}
}
