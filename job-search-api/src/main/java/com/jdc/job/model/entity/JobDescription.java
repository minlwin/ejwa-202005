package com.jdc.job.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class JobDescription implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
}
