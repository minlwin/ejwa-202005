package com.jdc.jpa.fetch.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ClassB {

	private String data;
	private int i;
}
