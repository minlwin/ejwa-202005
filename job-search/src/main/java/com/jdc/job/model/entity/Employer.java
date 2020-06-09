package com.jdc.job.model.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employer extends Member {

	private static final long serialVersionUID = 1L;

	public Employer() {
	}

}