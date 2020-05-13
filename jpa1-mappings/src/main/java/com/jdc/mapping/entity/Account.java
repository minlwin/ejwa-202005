package com.jdc.mapping.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT_TBL")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Basic(fetch = FetchType.LAZY)
	private String password;
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private Role role;
	private LocalDate dob;
	private String address;
	private String phone;
	@Column(name = "login_email", unique = true, nullable = false)
	private String email;
	
	@Transient
	private boolean checked;
	
	@Embedded
	private SecurityInfo security;
	

	public enum Gender {
		Male, Female
	}
	
	public enum Role {
		Admin, Owner, Member
	}
}
