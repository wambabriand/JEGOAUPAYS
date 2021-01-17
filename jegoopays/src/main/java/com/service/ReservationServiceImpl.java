package com.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
public class ReservationServiceImpl implements ReservationService {

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
					"Nous avons un coli pour vous. Nous vous contacterons une fois que le coli sera disponible dans un de nos point de retrait"
					+ " allez www.jegoopays.com");
			
			return new GenericResponse(true,"");
		}catch(Exception e) {
			return new GenericResponse(false, e.getMessage());
		}
	}
	

	@Override
	public GenericResponse confirmReservation(Reservation r) {
		try {
			Optional<Reservation> old = reservationRepository.findById(r.getId());
			if(old.isPresent()) {
				Reservation tmp = old.get();
				tmp.setConfirm(true);
				reservationRepository.saveAndFlush(tmp);
				return new GenericResponse(true, "");
			}
			return new GenericResponse(false, "Cette reservation n'existe pas");
		}
		catch(Exception e) {
			return new GenericResponse(false, e.getMessage());
		}
	}
	
	@Override
	public GenericResponse deleteReservation(Long id) {
		try {
			Optional<Reservation> r = reservationRepository.findById(id);
			if(r.isPresent()) {
				reservationRepository.deleteById(id);
				return new GenericResponse(true, "");
			}
			return new GenericResponse(false, "Cette reservation n'existe plus");
		}
		catch(Exception e) {
			return new GenericResponse(false, e.getMessage());
		}
	}
	
	@Override
	public List<Reservation> getAll(){
		List<Reservation> res = reservationRepository.findAll().stream().map(r->{r.getVoyage().setReservations(null); return r;}).collect(Collectors.toList());
		return res;
	}
	
	
}
