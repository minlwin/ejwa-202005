package com.jdc.job.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtTokenProvider jwtProvider;
	@Autowired
	private JwtUserDetailsService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			
			String username = jwtProvider.username(request);
						
			if(!StringUtils.isEmpty(username)) {
				UserDetails user = userService.loadUserByUsername(username);
				
				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(auth);
			} else {
				SecurityContextHolder.getContext().setAuthentication(null);
			}
			
		} catch (Exception e) {
			e.getSuppressed();
		}
		
		filterChain.doFilter(request, response);
	}

	
}
