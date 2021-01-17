package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.GenericResponse;
import com.entity.Voyage;
import com.repository.VoyageRepository;

@Service
public class VoyageServiceImpl implements VoyageService{
	
	@Autowired
	private VoyageRepository voyageRepository; 

	@Override
	public Voyage createVoyage(Voyage v) {
		
		Voyage voyage = new Voyage(v);
		try {
			voyageRepository.save(voyage);
			return voyage;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public GenericResponse updateVoyage(Voyage voyage) {
		try {
			voyageRepository.save(voyage);
		}
		catch(Exception e) {
			return new GenericResponse(false, e.getMessage());
		}
		return new GenericResponse(true, "");
	}
	

	@Override
	public GenericResponse deleteVoyage(Long id) {
		GenericResponse res = new GenericResponse(true, "");
		try {
			voyageRepository.deleteById(id);
		}
		catch(Exception e) {
			res.setResult(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public List<Voyage> getVoyage() {
		return voyageRepository.findAll().stream().map(v->{v.setReservations(null); return v;}).collect(Collectors.toList());
	}

}
