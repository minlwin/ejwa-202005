package com.jdc.job.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jdc.job.model.entity.Account;
import com.jdc.job.model.service.AccountService;

@Component
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private AccountService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = service.findById(username);
		
		return User.builder()
				.username(username)
				.password(account.getPassword())
				.roles(account.getRole().name())
				.disabled(false)
				.accountLocked(account.isDeleted())
				.build();
	}

}
