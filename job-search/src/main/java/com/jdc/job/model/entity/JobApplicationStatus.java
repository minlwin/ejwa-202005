package com.jdc.job.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class JobApplicationStatus implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private Status status;

	@Column(nullable = false)
	private LocalDate changeDate;

	private String remark;

	@ManyToOne(optional = false)
	private JobApplication application;

	public enum Status {
		Apply,
		PaperTest,
		Interview,
		Pass,
		Reject,
		Cancel
	}

}