package com.jdc.job.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jdc.job.model.entity.Member;
import com.jdc.job.model.repo.MemberRepo;

@Component
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = repo.findById(username).orElseThrow(() -> new UsernameNotFoundException("Invalid Member."));
		return User.builder()
				.username(username)
				.password(member.getPassword())
				.roles(member.getRole().name())
				.disabled(false)
				.build();
	}

}
