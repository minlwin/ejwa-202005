package com.jdc.job.security;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt.issuer}")
	private String issuer;
	@Value("${app.jwt.expiration}")
	private int expiration;
	@Value("${app.jwt.token}")
	private String token;
	
	private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	public String generate(String username, Collection<? extends GrantedAuthority> roles) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, expiration);
		
		return Jwts.builder()
				.setIssuer(issuer)
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.setSubject(username)
				.claim("rol", roles)
				.signWith(key)
				.compact();
	}
	
	public String username(HttpServletRequest req) {
		String jwtToken = req.getHeader(token);
		
		if(!StringUtils.isEmpty(jwtToken)) {
			return Jwts.parserBuilder()
				.requireIssuer(issuer)
				.setSigningKey(key)
				.build().parseClaimsJws(jwtToken).getBody().getSubject();
		}
		return null;
	}
}
