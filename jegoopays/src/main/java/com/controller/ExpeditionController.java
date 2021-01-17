package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.GenericResponse;
import com.forJson.MakeReservation;
import com.service.ExpeditionService;

@Controller
@CrossOrigin
public class ExpeditionController {
	
	
	@Autowired
	private ExpeditionService expeditionService;
	
	@RequestMapping(value = "/api/jego/unlock/poqsdqsdst/qsdreservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody GenericResponse makeResevation(@RequestBody MakeReservation infos) {
	
		
		System.out.println(infos);
		
		return expeditionService.createReservation(infos);
	}
	
}
