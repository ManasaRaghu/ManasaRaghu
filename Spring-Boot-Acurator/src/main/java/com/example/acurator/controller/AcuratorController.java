package com.example.acurator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcuratorController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello world";
	}

}
