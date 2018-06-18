package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PersonInOrder;
import com.example.demo.entity.UserRegister;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRegisterRequest;

public interface UserRegisterService {
	
	void save(UserRegister user);
	UserRegister findOne(long id);
	List<UserRegister> findAll();
	UserRegister register(UserRegister user);
	UserRegister findByEmail (String email);
	boolean login(LoginRequest loginRequest);
	boolean delete(long id);
	


}
