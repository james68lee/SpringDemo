package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/api")
public class HelloController {
//	@RequestMapping(value = "/say" , method = RequestMethod.GET)
//	@RequestMapping("/say")
//	@GetMapping("/say")
	@PostMapping("/say")
	public String hello() {
		return "Hello Spring Boot";
	}
	
	@GetMapping("/books")
	public String getAll() {
		return "books";
	}
	
	@PostMapping("/books")
	public Object post (@RequestParam("name") String name, 
			@RequestParam("author") String author,
			@RequestParam("id") long id) {
		return "Hello Spring Boot";
	}
}
