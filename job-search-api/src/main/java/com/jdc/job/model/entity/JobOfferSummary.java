package com.jdc.job.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class JobOfferSummary implements Serializable{

	private static final long serialVersionUID = 1L;

	private String qualification;
	private String expreiance;
	private String posts;
	private String salary;
}
