package com.jdc.job.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Member implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String login;

	private String password;

	private Role role;

	@OneToOne(mappedBy = "member")
	private Profile profile;

	public enum Role {
		Admin,
		Employee,
		Employer
	}

}