package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class UserController {

/*	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String test() {
		return "heloo world!";
	}
	*/
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "index.html";
	}
	
}
