package com.jdc.projection.model.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CourseDTO {

	int getId();
	String getName();
	String getDescription();
	
	@Value("#{target.id + '. ' + target.name}")
	String getViewName();
}
