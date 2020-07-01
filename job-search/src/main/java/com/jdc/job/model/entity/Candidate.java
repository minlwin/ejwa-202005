package com.jdc.job.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Candidate extends Member {

	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "candidate", fetch = FetchType.LAZY)
	private CvForm cvForm;

}