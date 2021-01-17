package com.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.entity.GenericResponse;

@CrossOrigin
@Controller
public class JournalController {

	
	@RequestMapping(value = "/api/jego/lock/admin/put/journal", method = RequestMethod.PUT, consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
	public GenericResponse setJournal(@RequestPart("journal") MultipartFile journal) {
		Path path = null;
		try {
			path= Paths.get("./journal.pdf");
		}
		catch(Exception e) {
			try {
				path = Files.createTempFile("./", "journal.pdf");
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		try {
			Files.write(path, journal.getBytes(), StandardOpenOption.CREATE);
		}
		catch(Exception e) {
			return new GenericResponse(false,"");
		}
		return new GenericResponse(true,"");
	}
}

