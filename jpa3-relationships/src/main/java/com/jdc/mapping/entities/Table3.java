package com.jdc.mapping.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Table3 {

	@Id
	private int id;
	private String name;
	
	@ManyToMany
	private Set<Table2> table2;
	
}
