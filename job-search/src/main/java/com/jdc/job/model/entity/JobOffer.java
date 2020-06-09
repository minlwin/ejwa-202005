package com.jdc.job.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class JobOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String title;

	private String position;

	private String contractType;

	private String description;

	private String workingHours;

	@ElementCollection
	private List<String> workingDays;

	@ElementCollection
	private List<String> requirements;

	private String salary;

	@ElementCollection
	@MapKeyColumn(name = "type")
	private Map<String, Integer> allowances;

	private LocalDate lastDate;

	@OneToOne
	private Address address;

	@ManyToOne
	private CompanyMember incharge;

}