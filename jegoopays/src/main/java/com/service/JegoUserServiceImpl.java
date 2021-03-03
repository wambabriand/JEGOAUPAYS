package com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.repository.JegoUserRepository;
import com.entity.JegoUser;

@Service
public class JegoUserServiceImpl implements JegoUserService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JegoUserRepository jegoUserRepository;
	
	private List<JegoUser> getUsers(){
		List<JegoUser> users = Lists.newArrayList(
				 new JegoUser("admin",passwordEncoder.encode("admin"),"admin","admin", "admin" ),
				 new JegoUser("user",passwordEncoder.encode("user"),"user", "user", "user" )
				);
		return users;
	}
	
	
	
	@Override
	public JegoUser getJegoUserByEmail(String email) {
		JegoUser tmp = jegoUserRepository.getJegoUserByEmail(email);
		Optional<JegoUser> user =  getUsers().stream().filter(u->u.getEmail().equals(email))
				.findFirst();

		System.out.println( "je suis ici dans ricerca user " );
		System.out.println( user.isPresent() );
		
		if(user.isEmpty()) 
			return null;
		return user.get();
	}

}
