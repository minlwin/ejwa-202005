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
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT_TBL")
@SecondaryTables({
		@SecondaryTable(name = "contact"),
		@SecondaryTable(name = "profile")
})
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "login_email", unique = true, nullable = false)
	private String email;
	@Basic(fetch = FetchType.LAZY)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(table = "profile")
	private String name;
	@Column(table = "profile")
	private Gender gender;
	@Column(table = "profile")
	private LocalDate dob;
	
	@Column(table = "contact")
	private String address;
	@Column(table = "contact")
	private String phone;
	
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
