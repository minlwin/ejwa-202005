package com.jdc.job.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Property implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String value;
}
