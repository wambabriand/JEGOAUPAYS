package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.service.JegoUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private JegoUserService jegoUserService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return jegoUserService.getJegoUserByEmail(username);
	}
}

