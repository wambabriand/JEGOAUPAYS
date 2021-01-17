package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.GenericResponse;
import com.entity.Reservation;
import com.forJson.MakeReservation;
import com.service.ReservationService;

@Controller
public class ReservationController {

	
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value = "/api/jego/lock/admin/get/reservations", method = RequestMethod.GET)
	public @ResponseBody List<Reservation> getAllReservation(){
		//System.out.println("i am here for loading data");
		//System.out.println(reservationService.getAll());
		System.out.println("je ++++++++++++++++++++++++");
		return reservationService.getAll();
	}
	
	@RequestMapping(value = "/api/jego/unlock/post/reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody GenericResponse makeResevation(@RequestBody MakeReservation infos) {
	
		//  je peux preparer un message et envoyer a helsa
		System.out.println("je suis la post");
		
		return reservationService.createReservation(infos);
	}


	@RequestMapping(value = "/api/jego/lock/admin/put/confirmReservation", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody GenericResponse confirmReservation(@RequestBody Reservation reservation) {
		//  je peux preparer un message et envoyer a helsa
		System.out.println("je suis dans la put");
		System.out.println(reservation);
		return reservationService.confirmReservation(reservation);
	}

	
	@RequestMapping(value = "/api/jego/lock/admin/delete/reservation", method = RequestMethod.DELETE)
	public @ResponseBody GenericResponse deleteResevationByAdmin(@RequestBody Reservation reservation) {
		//  je peux preparer un message et envoyer a helsa
		System.out.println("je suis dans la delete");
		return reservationService.deleteReservation(reservation.getId());
	}

	 
}
