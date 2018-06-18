package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRegister;
import com.example.demo.repository.UserRegisterRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.UserRegisterRequest;
import com.example.demo.service.UserRegisterService;

@Service
public class UserRegisterServiceImpl implements UserRegisterService, UserDetailsService {
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;

	@Override
	public void save(UserRegister user) {
		userRegisterRepository.save(user);
		
	}
	@Override
	public boolean delete(long id) {
		userRegisterRepository.delete(id);
		return false;
	}

	@Override
	public UserRegister findOne(long id) {
		return userRegisterRepository.findOne(id);
	}

	@Override
	public List<UserRegister> findAll() {
		return userRegisterRepository.findAll();
	}

	@Override
	public UserRegister findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRegister register(UserRegister user) {
		return userRegisterRepository.save(user);
	}

	@Override
	public boolean login(LoginRequest loginRequest) {
		if(loginRequest!=null){
			UserRegister user  = userRegisterRepository.findByEmail(loginRequest.getEmail());
			if(user!=null){
				if(user.getPassword().equals(loginRequest.getPassword())){
					return true;
				}else{
					throw new IllegalArgumentException("Login or password is incorrect");
				}
			}else{
				throw new IllegalArgumentException("Login or password is incorrect");
			}
		}else{
			throw new IllegalArgumentException("LoginRequest not be null");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRegisterRepository.findByEmail(username);
	}
}
