package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.email.EmailSenderService;
import com.entity.GenericResponse;
import com.forJson.ContactUs;

@Controller
@CrossOrigin
public class ContactUsController {
	
	@Autowired
	private EmailSenderService emailSenderService;

	@RequestMapping(value = "/api/jego/unlock/post/contactUs", method = RequestMethod.POST)
	public @ResponseBody GenericResponse contactUs(@RequestBody ContactUs data) {
		
		System.out.println(data);
		
		try {
			emailSenderService.sendSimpleMessage("briandwamba@yahoo.fr", "CONTACT US: "+data.getObjet(), 
								                 "Nom : "+data.getNom()+ "\n Phone: "+ data.getPhoneNumber()+"\n\n "+ data.getContent());

			emailSenderService.sendSimpleMessage(data.getEmail1(), "No Reply: Accuser de reception", 
								                 "Merci de nous avoir contacté. Nos equipes vous contacterons dans 24h.");
		}
		catch(Exception e) {
			System.out.println();
			return new GenericResponse(false, e.getMessage());
		}

		return new GenericResponse(true, "");
	}
	
}
