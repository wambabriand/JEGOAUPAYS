package com.service;

import java.util.List;

import com.entity.GenericResponse;
import com.entity.Reservation;
import com.forJson.MakeReservation;

public interface ExpeditionService {

	public GenericResponse createReservation(MakeReservation m);
	public GenericResponse deleteReservation(Long id);
	public List<Reservation> getAll();
	
}
