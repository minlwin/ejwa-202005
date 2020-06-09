package com.jdc.job.model;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import javax.persistence.AttributeConverter;

import static org.springframework.util.StringUtils.isEmpty;

public class YearMonthConverter implements AttributeConverter<YearMonth, String> {
	
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyyMM");

	@Override
	public String convertToDatabaseColumn(YearMonth attribute) {
		
		if(null == attribute) {
			return null;
		}
		
		return attribute.format(DF);
	}

	@Override
	public YearMonth convertToEntityAttribute(String dbData) {
		
		if(isEmpty(dbData)) {
			return null;
		}
		
		return YearMonth.parse(dbData, DF);
	}

}
