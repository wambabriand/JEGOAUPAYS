package com.service;

import java.util.List;


import com.entity.GenericResponse;
import com.entity.Voyage;

public interface VoyageService {
	
	public Voyage createVoyage(Voyage voyage);
	
	public GenericResponse updateVoyage(Voyage voyage);
	
	public GenericResponse deleteVoyage(Long id);
	
	
	public List<Voyage> getVoyage();
	

}
