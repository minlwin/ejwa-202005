package com.jdc.mapping.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Table1 {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne
	private Table2 table2;
}
