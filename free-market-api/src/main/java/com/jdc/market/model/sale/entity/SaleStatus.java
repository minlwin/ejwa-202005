package com.jdc.market.model.sale.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class SaleStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Sale sale;
	private Status status;
	private String message;
	private LocalDate issueDate;
	private LocalTime issueTime;

	public enum Status {
		Ordered, Cancel, Delevered, Accepted
	}
}
