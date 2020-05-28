package com.jdc.projection.model.dto;

import org.springframework.beans.factory.annotation.Value;

public interface SectionDTO {
	
	int getId();
	
	int getPriority();

	String getName();
	
	CourseDTO getCourse();
	
	@Value("#{target.priority + '. ' + target.name}")
	String getViewName();

}
