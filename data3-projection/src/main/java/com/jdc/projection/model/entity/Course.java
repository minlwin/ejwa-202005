package com.jdc.projection.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	private String description;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER,
			cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
			orphanRemoval = true)
	private List<Section> sections;

	public Course() {
		sections = new ArrayList<>();
	}
	

	public Course(String name) {
		super();
		this.name = name;
	}

	
	public void addSection(Section s) {
		s.setCourse(this);
		s.setPriority(sections.size());
		this.sections.add(s);
	}

}
