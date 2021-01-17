package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AllUrlController {

	@RequestMapping(value = "/apropos",method = RequestMethod.GET  )
	public String apropos(){
		return "forward:/";
	}
	@RequestMapping(value = "/register",method = RequestMethod.GET  )
	public String register(){ 
		return "forward:/";
	}
	
	@RequestMapping(value = "/conatcts",method = RequestMethod.GET  )
	public String conatcts(){ 
		return "forward:/";
	}
	
	@RequestMapping(value = "/partners",method = RequestMethod.GET  )
	public String partners(){ 
		return "forward:/";
	}
	
	@RequestMapping(value = "/expedie",method = RequestMethod.GET  )
	public String expedie(){ 
		return "forward:/";
	}
	
	@RequestMapping(value = "/services",method = RequestMethod.GET  )
	public String services(){ 
		return "forward:/";
	}
	
	@RequestMapping(value = "/vendreBagage",method = RequestMethod.GET  )
	public String vendreBagage(){ 
		return "forward:/";
	}
	
}
