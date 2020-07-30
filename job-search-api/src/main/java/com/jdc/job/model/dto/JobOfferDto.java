package com.jdc.job.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.jdc.job.model.entity.JobDescription;
import com.jdc.job.model.entity.JobOffer.Status;

import lombok.Data;

@Data
public class JobOfferDto {

	private String title;
	private String location;
	private String jobType;
	private int company;
	private String qualification;
	private String expreiance;
	private String posts;
	private String salary;
	private List<JobDescription> descriptions = new ArrayList<>();
	private Status status;
}
