package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserRegister;

public interface UserRegisterRepository extends JpaRepository<UserRegister, Long>  {
	
	UserRegister findByEmail(String email);

}
