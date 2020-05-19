package com.jdc.mapping.entities;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Classes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate startDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private double duration;
	
	@ElementCollection
	private List<DayOfWeek> days;
	
	@ManyToOne
	private Course course;
	@OneToMany
	private List<Teacher> teachers;
	@ManyToOne
	private Teacher headTeacher;

}
