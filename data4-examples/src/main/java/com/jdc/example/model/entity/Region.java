package com.jdc.example.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Region implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	private String region;
	private String capital;

	@OneToMany(mappedBy = "region", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Township> townships;
	
	public Region() {
		townships = new ArrayList<>();
	}
	
	public void addTownship(Township t) {
		t.setRegion(this);
		townships.add(t);
	}

	public static Region withCapital(String c) {
		Region r = new Region();
		r.setCapital(c);
		return r;
	}
}
