package com.jdc.job.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.job.model.dto.LoginDto;
import com.jdc.job.model.dto.LoginResult;
import com.jdc.job.model.entity.Member;
import com.jdc.job.model.repo.MemberRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private MemberRepo memberRepo;

	@PostMapping
	public LoginResult login(@RequestBody LoginDto dto) {
		LoginResult result = new LoginResult();
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		if(auth.isAuthenticated()) {
			result.setSuccess(true);
			Optional<Member> optional = memberRepo.findById(auth.getName());
			optional.ifPresent(data -> {
				result.setName(data.getProfile().getName());
				result.setRole(data.getRole());
			});
		} else {
			result.setMessage("Invalid Login Information.");
		}
		
		return result;
	}
}
