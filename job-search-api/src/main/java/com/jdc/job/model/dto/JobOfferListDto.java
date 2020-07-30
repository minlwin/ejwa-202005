package com.jdc.job.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.jdc.job.model.entity.JobOffer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobOfferListDto {

	private long id;
	private String title;
	private int companyId;
	private String companyName;
	private String companyLogo;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate postDate;
	private String location;
	private int applications;
	
	public JobOfferListDto() {
	}
	
	public JobOfferListDto(JobOffer job, int applications) {
		this.id = job.getId();
		this.title = job.getTitle();
		this.companyId = job.getCompany().getId();
		this.companyName = job.getCompany().getName();
		this.companyLogo = job.getCompany().getLogo();
		this.postDate = job.getPostDate();
		this.location = job.getLocation();
		this.applications = applications;
	}
	
}
