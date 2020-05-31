package com.jdc.market.model.sale.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.market.model.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "SLE_SALE_STATUS")
public class SaleStatus implements BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
