package com.jdc.job.model.dto;

import com.jdc.job.model.entity.Member.Role;

import lombok.Data;

@Data
public class LoginResult {

	private String name;
	private Role role;
	private boolean success;
	private String message;
}
