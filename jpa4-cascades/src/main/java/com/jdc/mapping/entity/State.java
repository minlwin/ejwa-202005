package com.jdc.mapping.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(
			mappedBy = "state", 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
			orphanRemoval = true)
	private List<Township> townships;
}
