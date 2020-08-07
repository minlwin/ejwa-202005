package com.jdc.job.model.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.job.model.dto.LoginDto;
import com.jdc.job.model.dto.LoginResultDto;
import com.jdc.job.model.dto.SignUpDto;
import com.jdc.job.model.entity.Account;
import com.jdc.job.model.repo.AccountRepo;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager auth;

	public LoginResultDto login(LoginDto login) {
		return login(login.getEmail(), login.getPassword());
	}

	public LoginResultDto signUp(SignUpDto dto) {
		
		if(repo.findById(dto.getEmail()).orElse(null) != null) {
			LoginResultDto result = new LoginResultDto();
			result.setSuccess(false);
			result.setMessage(String.format("%s has been registered in this system.", dto.getEmail()));
			SecurityContextHolder.getContext().setAuthentication(null);
			return result;
		}
		
		Account account = new Account();
		account.setEmail(dto.getEmail());
		account.setName(dto.getName());
		account.setPassword(encoder.encode(dto.getPassword()));
		account.setRole(dto.getRole());
		repo.save(account);
		
		return login(dto.getEmail(), dto.getPassword());
	}

	public long count() {
		return repo.count();
	}
	
	private LoginResultDto login(String email, String password) {
		LoginResultDto dto = new LoginResultDto();
		SecurityContextHolder.getContext().setAuthentication(null);
		
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
			Authentication authentication = auth.authenticate(token);
			
			if(authentication.isAuthenticated()) {
				Account account = findById(email);
				dto.setName(account.getName());
				dto.setRole(account.getRole());
				
				dto.setCompany(account.getCompany() == null ? 0 : account.getCompany().getId());
				
				dto.setSuccess(true);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} else {
				dto.setMessage("Authentication Fails!");
			}
		} catch(EntityNotFoundException | InternalAuthenticationServiceException e) {
			dto.setMessage("Please check your email.");
		} catch(BadCredentialsException e) {
			dto.setMessage("Please check your password.");
		} 
		
		return dto;
	}

	public Account findById(String username) {
		return repo.findById(username).orElseThrow(() -> new EntityNotFoundException());
	}

	public Account getLoginUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		return findById(userName);
	}

}
