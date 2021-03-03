package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.JegoUser;

public interface JegoUserRepository extends JpaRepository<JegoUser, Long>{

	@Query("SELECT u FROM JegoUser u WHERE u.email = ?1")
	public JegoUser getJegoUserByEmail(String email);
}
