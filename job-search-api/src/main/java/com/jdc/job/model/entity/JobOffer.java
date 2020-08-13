package com.jdc.job.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "JOB_OFFER")
@NamedQuery(name = "JobOffer.findForCompany", 
	query = "select new com.jdc.job.model.dto.JobOfferListDto(j, 0) from JobOffer j where j.company.id = :company and j.status = :status")
public class JobOffer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String location;
	private String jobType;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate postDate;
	@ManyToOne
	private Company company;
	@Embedded
	private JobOfferSummary summary;
	@ElementCollection
	@CollectionTable(name = "JOB_OFFER_DESCRIPTIONS")
	private List<JobDescription> descriptions = new ArrayList<>();
	
	private Status status;
	
	public enum Status {
		Saved, Published, Finish
	}
	
}
