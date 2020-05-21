package com.jdc.lazy;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ClassB implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private int count;
}
