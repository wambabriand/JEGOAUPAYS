package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.email.EmailSenderService;
import com.entity.GenericResponse;

@Controller
@CrossOrigin
public class SellBaggageController {
	
	
	@Autowired
	private EmailSenderService emailSenderService;


	@RequestMapping(value ="/api/jego/unlock/post/voyage", method = RequestMethod.POST,consumes =  MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody GenericResponse sellBaggage(@RequestPart("file1") MultipartFile file1, @RequestPart("file2")MultipartFile file2,
		   @RequestPart("email") String email, @RequestPart("phoneNumber") String phoneNumber, @RequestPart("villesDeparture") String villesDeparture,
		   @RequestPart("villesArrival") String villesArrival, @RequestPart("comment") String comment, @RequestPart("date") String date,
		   @RequestPart("kgAvailable") String kgAvailable, @RequestPart("priceByKg") String priceByKg) {
		
		
		List<MultipartFile> files = new ArrayList<MultipartFile>();
		files.add(file1);
		files.add(file2);
		
		GenericResponse res =  new GenericResponse(true,"");
	
		String message = "<p>Voici une nouvelle reservation.</p>"
						 +"<p>Email : "+email
						 +"</p><p>Numero telephone: "+ phoneNumber
						 +"</p><p>Date: "+ date
						 +"</p><p>Villes de departs: "+ villesDeparture
						 +"</p><p>Villes de d'arrivées: "+ villesArrival
						 +"</p><p>Nombre de Kg Disponible: "+ kgAvailable
						 +"</p><p>Prix du Kg: "+ priceByKg
						 +"</p><p> Regarder en pj pour voir les documents fournis </p>";
		
		
		String message2 = "<p>Votre demande à bien été prise en compte. Vous allez etre contacter à bref pour plus de details"
						 +"</p><p> JeGoOPays vous remercie de votre confiance.</p>";
		
		String to ="briandwamba@gmail.com";// il nous faut l'adresse de l admin ici
		
		// I send accuse of reception to client
		if( !emailSenderService.sendSimpleMessage(email, "ACCUSER DE RECEPTION", message2) ) {
			res.setResult(false);
			res.setMessage("email");
			return res;
		}
		
		/* I send message to admin*/
		if( !emailSenderService.sendMessageWithAttachment(to, "KG DISPONIBLE A VENDRE", message, files) ) {
			res.setResult(false);
			res.setMessage("admin");
		}
		
		
		return res;
	}
	
}
