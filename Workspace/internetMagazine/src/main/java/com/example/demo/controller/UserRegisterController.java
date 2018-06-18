package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GoodsInOrder;
import com.example.demo.entity.UserRegister;
import com.example.demo.request.FindOneUserRegisterRequest;
import com.example.demo.request.GoodsInOrdersRequest;
import com.example.demo.request.LoginRequest;
import com.example.demo.service.UserRegisterService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRegisterController {
	
	@Autowired
	private UserRegisterService userRegistService;
	
	@PutMapping
	public UserRegister register(@RequestBody UserRegister userRegister) {
		return userRegistService.register(userRegister);
	}
	@PostMapping
	public boolean login(@RequestBody LoginRequest loginRequest) {
		return userRegistService.login(loginRequest);
	}
	@DeleteMapping
	public boolean delete(@RequestBody FindOneUserRegisterRequest request) {
		return userRegistService.delete(request.getId());
	}
}
