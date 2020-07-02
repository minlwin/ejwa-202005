package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.dto.LoginDto;
import com.jdc.job.model.dto.LoginResultDto;
import com.jdc.job.model.dto.SignUpDto;
import com.jdc.job.model.service.AccountService;

@RestController
@RequestMapping("auth")
public class AuthApi {
	
	@Autowired
	private AccountService service;
	
	@PostMapping("login")
	public LoginResultDto login(LoginDto login) {
		return service.login(login);
	}
	
	@PostMapping("signup")
	public LoginResultDto signUp(SignUpDto dto) {
		return service.signUp(dto);
	}
	

}
