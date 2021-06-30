package com.example.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleJpaController {
	@RequestMapping("/")  
	public String home()  
	{  
	return "home.jsp";  
	}  
}
