package com.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.GenericResponse;
import com.entity.Voyage;
import com.forJson.FileMultimedia;
import com.service.VoyageService;

@Controller
@CrossOrigin
public class VoyageController {

	@Autowired
	private VoyageService voyageService;
	

	@RequestMapping(value = "/api/jego/unlock/get/voyages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Voyage> getAllVoyage() {
		return voyageService.getVoyage();
	}
	
	
	
	@RequestMapping(value = "/api/jego/lock/delete/voyage", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody GenericResponse deleteVoyage(@RequestBody Voyage data) {
		return voyageService.deleteVoyage(data.getId());
	}
	
	@RequestMapping(value = "/api/jego/lock/admin/post/voyage",method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody Voyage AddVoyage(@RequestBody Voyage data){ 
		return voyageService.createVoyage(data);
	}
	
	@RequestMapping(value = "/api/jego/lock/admin/put/voyage",method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody GenericResponse updateVoyage(@RequestBody Voyage data){ 
		System.out.println( "je suis dnas update" );
		System.out.println( data );
		return voyageService.updateVoyage(data);
	}
	
	
	// cette url doit etre changer
	@RequestMapping(value = "api/jego/unlock/get/journal", method = RequestMethod.GET  )
	public @ResponseBody FileMultimedia getMultimediaFile() {
		FileMultimedia file= new FileMultimedia();
		try {
			Path path = Paths.get("./journal.pdf");
			byte [] data  = Files.readAllBytes(path);
			file.setPresent(true);
			file.setName("journal.pdf");
			file.setFilebytes(data);
		} catch (IOException e) {
			file.setPresent(false);
			file.setName(e.getMessage());
			e.printStackTrace();
		}
		
		return file;
	}
	

	
/*	@RequestMapping(value = "/",method = RequestMethod.GET  )
	public String myGetHome(){ 
		System.out.println("je veux faire la forward");
		return "forward:/";
	}
	*/
	
	@RequestMapping(value = "/api/admin/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Voyage> testadmin() {
		System.out.println("nothing change");
		return voyageService.getVoyage();
	}

	@RequestMapping(value = "/api/user/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Voyage> testuser() {
		System.out.println("nothing change");
		return voyageService.getVoyage();
	}

	@RequestMapping(value = "/api/all/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Voyage> testall() {
		System.out.println("nothing change");
		return voyageService.getVoyage();
	}
	
	
	
	@RequestMapping(value = "/api/jego/post/voyage",method = RequestMethod.POST )
	public @ResponseBody Voyage createExpeditionVoyage(){ // @RequestBody MultipartFile file1 , @RequestParam("fileName") String fileName
		//return expeditionService.createExpeditionVoyage(voyage); , consumes = MediaType.APPLICATION_JSON_VALUE @RequestPart
		
		//System.out.println( file1.getSize());
	/*	System.out.println(fileName);
		
		try {
			Path path = Paths.get("C:\\Users\\brian\\Desktop\\file1."+ file1.getContentType().substring(6) );
			//System.out.println(path);
			//Files.write(path, file1.getBytes(),StandardOpenOption.CREATE);
			//System.out.println("fin d'envoi du message1");
			//emailSenderService.sendSimpleMessage("briandwamba@gmail.com", "nana", "sqsdqsdqsd");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
			*/
		
		//Voyage voyage = new Voyage();
		return voyageService.createVoyage(null);
		//return var;
	}
	
	
}
