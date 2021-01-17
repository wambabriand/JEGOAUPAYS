package com.security;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import com.forJson.LoggedUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtAuthenFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;
	
	public JwtAuthenFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			String credentials = new String( request.getInputStream().readAllBytes() );
			UsernamePassword usernamePassword = new ObjectMapper().readValue(credentials, UsernamePassword.class);
			Authentication authentication = new UsernamePasswordAuthenticationToken(usernamePassword.getUsername(), usernamePassword.getPassword());
			Authentication authenticated = authenticationManager.authenticate(authentication);
			return authenticated;
		}
		catch( IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String token = Jwts.builder()
				.setSubject(authResult.getName())
				.claim("authorities", authResult.getAuthorities())
				.setIssuedAt( new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
				.signWith(Keys.hmacShaKeyFor("securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecure".getBytes()))
				.compact();
			
			//response.addHeader("Authorization", "Bearer "+token);
			
			LoggedUser  user = new LoggedUser(token, authResult.getName(), authResult.getName());
			Gson gson = new Gson();
			String json = gson.toJson(user);
			response.getWriter().write(json);
		
	}
	

}
