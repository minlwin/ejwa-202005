package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.dto.LoginDto;
import com.jdc.job.model.dto.LoginResult;
import com.jdc.job.model.dto.SignUpDto;
import com.jdc.job.model.service.MemberService;

@RestController
@RequestMapping("auth")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private MemberService service;

	@PostMapping("login")
	public LoginResult login(@RequestBody LoginDto dto) {
		return login(dto.getEmail(), dto.getPassword());
	}
	
	@PostMapping("signup")
	public LoginResult signUp(SignUpDto dto) {
		
		// create member according to role
		service.signUp(dto);
		
		// internal login
		return login(dto.getEmail(), dto.getPassword());
	}
	
	private LoginResult login(String email, String password) {
		
		LoginResult result = new LoginResult();
		
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		
		if(auth.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(auth);
			service.setLoginIfo(result, auth.getName());
		} else {
			result.setMessage("Invalid Login Information.");
		}
		
		return result;		
	}
}
