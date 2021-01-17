package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Voyage;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long>{

}
