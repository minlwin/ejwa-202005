package com.jdc.job.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class JwtTokenAdvice implements ResponseBodyAdvice<Object>{
	
	@Autowired
	private JwtTokenProvider provider;
	@Value("${app.jwt.token}")
	private String token;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(null != authentication && authentication.isAuthenticated()) {
			// generate token
			String jwtToken = provider.generate(authentication.getName(), authentication.getAuthorities());
			
			// add token to header
			ServletServerHttpResponse resp = (ServletServerHttpResponse) response;
			resp.getServletResponse().setHeader(token, jwtToken);
		}
		
		return body;
	}

}
