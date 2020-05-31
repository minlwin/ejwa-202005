package com.jdc.market.model.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jdc.market.model.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "MST_MEMBER")
public class Member implements BaseEntity<String>{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "login_id")
	private String id;
	private String name;
	
	@JsonIgnore
	private String password;
	private String profileImage;
	private String email;
	
	private Role role;
	private boolean valid;
	
	public enum Role {
		Admin, Member
	}

}
