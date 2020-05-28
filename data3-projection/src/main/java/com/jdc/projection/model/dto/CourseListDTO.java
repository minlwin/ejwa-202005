package com.jdc.projection.model.dto;

import lombok.Data;

@Data
public class CourseListDTO {

	private int id;
	private String name;
	private String description;

	public CourseListDTO(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
