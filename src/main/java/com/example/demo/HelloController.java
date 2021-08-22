package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/home")
	public String getHome() {
		
		// hello word
		return "hello spring security rocks!!!";
	}
}
