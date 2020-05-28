package com.jdc.projection.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Section implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne
	private Course course;
	private String description;
	private int priority;
	
	@OneToMany(mappedBy = "section", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Lesson> lessons;
	
	public Section() {
		lessons = new ArrayList<>();
	}

	public Section(String name) {
		this();
		this.name = name;
	}
	
	public void addLesson(Lesson l) {
		l.setSection(this);
		l.setPriority(lessons.size());
		lessons.add(l);
	}
	
}
