package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.EmailSenderService;
import com.entity.GenericResponse;
import com.entity.Reservation;
import com.entity.Voyage;
import com.forJson.MakeReservation;
import com.repository.ReservationRepository;
import com.repository.VoyageRepository;

@Service
public class ExpeditionServiceImpl implements ExpeditionService{

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private VoyageRepository voyageRepository;
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Override
	public GenericResponse createReservation(MakeReservation m) {
		
		Optional<Voyage> Ov = voyageRepository.findById(m.getIdVoyage());
		if(Ov.isEmpty()) {
			return new GenericResponse(false, "Ce voyage n'est plus disponible. ID: "+ m.getIdVoyage());
		}
		Reservation r = new Reservation(m, Ov.get());
		try {
			reservationRepository.save(r);
			emailSenderService.sendSimpleMessage(m.getEmailSen(), "Accuser de reception", 
					"Nous avons bien recu votre demande. Nous allons vous contacter dans les prochaine 48 heures");
			emailSenderService.sendSimpleMessage(m.getEmailRec(), "Accuser de reception", 
					"Nous avons un coli pour vous. Nous vous contacterons une fois le coli sera disponible dans un de nos point de livraison"
					+ " allez www.jegoopays.com");
			
		}catch(Exception e) {
			return new GenericResponse(false, e.getMessage());
		}
		
		return new GenericResponse(true,"");
	}

	@Override
	public GenericResponse deleteReservation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Reservation> getAll(){
		return reservationRepository.findAll();
	}
	
	
	
}
