package com.jdc.market.model.master.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "MST_MEMBER")
public class Member implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String loginId;
	private String name;
	
	@JsonIgnore
	private String password;
	private String profileImage;
	private String email;
	
	private Role role;
	private boolean valid;
	
	public enum Role {
		Admin, Trusted, Member
	}

}
