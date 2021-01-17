package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.GenericResponse;
import com.forJson.UpdataPwd;

@CrossOrigin
@Controller
public class AdminController {

	
	@RequestMapping(value = "/api/jego/lock/admin/put/password", method = RequestMethod.PUT)
	public @ResponseBody GenericResponse updatePassword(@RequestBody UpdataPwd data) {
	
		System.out.println("je mets à jour la password" + data.getEmail());
		return new GenericResponse(true,"");
	}
	

	@RequestMapping(value = "/login",method = RequestMethod.GET  )
	public String loginn(){ 
		return "forward:/";
	}
	
	@RequestMapping(value = "/login/**",method = RequestMethod.GET  )
	public String Allloginn(){ 
		return "forward:/";
	}
	

	@RequestMapping(value = "/admin",method = RequestMethod.GET  )
	public String admin(){ 
		return "forward:/";
	}
	
	@RequestMapping(value = "/admin/**",method = RequestMethod.GET  )
	public String allAdmin(){
		return "forward:/";
	}
	
}
