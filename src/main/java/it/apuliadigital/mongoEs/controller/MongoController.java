package it.apuliadigital.mongoEs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
}