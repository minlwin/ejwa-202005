package com.jdc.job.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class CvForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate dob;

	private Gender gender;

	@OneToOne
	private Address address;

	private String presentation;

	private String otherMemo;

	@ElementCollection
	private List<String> requests;

	@OneToOne(optional = false)
	private Candidate candidate;

	@OneToMany(mappedBy = "cvForm", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<EducationHistory> educations;

	@OneToMany(mappedBy = "cvForm", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<WorkHistory> works;

	@OneToMany(mappedBy = "cvForm", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Acchivement> acchivements;

	public enum Gender {
		Male,
		Female
	}

}