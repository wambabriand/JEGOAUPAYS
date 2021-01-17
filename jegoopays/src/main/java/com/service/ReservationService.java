package com.service;

import java.util.List;

import com.entity.GenericResponse;
import com.entity.Reservation;
import com.forJson.MakeReservation;

public interface ReservationService {

	public GenericResponse createReservation(MakeReservation m);
	public GenericResponse deleteReservation(Long id);
	public GenericResponse confirmReservation(Reservation r);
	public List<Reservation> getAll();
}
