package com.jdc.job.model.dto;

import lombok.Data;

@Data
public class LoginResultDto {

	private String name;
	private String role;
	private boolean success;
	private String message;
}
