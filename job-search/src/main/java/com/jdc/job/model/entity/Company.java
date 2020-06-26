package com.jdc.job.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	private String phone;
	private String email;

	@ElementCollection
	private List<Property> properties = new ArrayList<>();
	@JsonIgnore
	@ElementCollection
	private List<String> images = new ArrayList<>();


	@ManyToOne(optional = false)
	private Employer owner;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private Address address;

}