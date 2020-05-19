package com.jdc.mapping.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import javax.persistence.OneToMany;

@Entity
@Data
public class Table2 {

	@Id
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "table2")
	private Set<Table3> table3;
	
	@OneToMany(mappedBy = "table2")
	private Set<Table1> table1;
}
