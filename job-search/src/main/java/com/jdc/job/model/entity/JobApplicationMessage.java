package com.jdc.job.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class JobApplicationMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private LocalDate sendDate;

	@Column(nullable = false)
	private String message;

	@ManyToOne(optional = false)
	private Member sender;

	@ManyToOne(optional = false)
	private JobApplication application;

}