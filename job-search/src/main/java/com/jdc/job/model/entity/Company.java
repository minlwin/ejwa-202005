package com.jdc.job.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String category;
 
	private String coverPhoto;

	private String greeting;
	
	private String homePage;

	@ElementCollection
	@MapKeyColumn(name = "property")
	private Map<String, String> properties = new HashMap<>();
	@JsonIgnore
	@ElementCollection
	private List<String> images = new ArrayList<>();


	@ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Employer owner;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Address address;

}