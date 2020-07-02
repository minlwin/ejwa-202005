package com.jdc.job.model.dto;

import com.jdc.job.model.entity.Account.Role;

import lombok.Data;

@Data
public class SignUpDto {

	private String email;
	private String name;
	private String password;
	private Role role;

}
