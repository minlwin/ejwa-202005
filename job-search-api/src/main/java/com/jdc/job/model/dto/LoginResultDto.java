package com.jdc.job.model.dto;

import com.jdc.job.model.entity.Account.Role;

import lombok.Data;

@Data
public class LoginResultDto {

	private String name;
	private Role role;
	private boolean hasOwnCompany;
	private boolean success;
	private String message;
}
