package com.jdc.job.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Account owner;
	private String name;
	private String category;
	private String founded;
	private String location;
	private String size;
	private String homePage;
	private String logo;
	@Column(columnDefinition = "TEXT")
	private String aboutUs;
	@Column(columnDefinition = "TEXT")
	private String visions;
}
