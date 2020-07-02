package com.jdc.job.model.service;

import org.springframework.beans.factory.annotation.Autowired;
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

	public LoginResultDto login(LoginDto login) {
		return login(login.getEmail(), login.getPassword());
	}

	public LoginResultDto signUp(SignUpDto dto) {
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
		// TODO Authentication
		
		return dto;
	}

	public Account findById(String username) {
		return repo.findById(username).orElseThrow();
	}

}
