package com.jdc.job.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter{

	@Autowired
	private JwtTokenProvider provider;
	@Autowired
	private JwtUserDetailsService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// check token
		String username = provider.userName(request);
		
		SecurityContext security = SecurityContextHolder.getContext();
		
		if(!StringUtils.isEmpty(username)) {
			
			UserDetails user = service.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken auth = 
					new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
			
			security.setAuthentication(auth);
		} else {
			// delete authentication
			security.setAuthentication(null);
		}
		
		filterChain.doFilter(request, response);
	}
}
