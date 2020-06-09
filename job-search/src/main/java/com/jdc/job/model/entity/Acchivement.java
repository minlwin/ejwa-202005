package com.jdc.job.model.entity;

import java.io.Serializable;
import java.time.YearMonth;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jdc.job.model.YearMonthConverter;

import lombok.Data;

@Entity
@Data
public class Acchivement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	@Convert(converter = YearMonthConverter.class)
	private YearMonth month;

	@Column(nullable = false)
	private String details;
	
	@ManyToOne(optional = false)
	private CvForm cvForm;


}