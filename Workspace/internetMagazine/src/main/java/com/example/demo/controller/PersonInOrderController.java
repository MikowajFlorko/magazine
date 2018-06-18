package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PersonInOrderService;

@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonInOrderController {
	
	@Autowired
	private PersonInOrderService personService;

//	@PutMapping
//	public Person register(@RequestBody PersonRequest personRequest) {
//		return personService.register(personRequest);
//		
//	}
}
