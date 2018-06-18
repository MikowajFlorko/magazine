package com.example.demo.controller;

import org.apache.http.client.protocol.ResponseContentEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.LoginRequest;
import com.example.demo.security.TokenUtils;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class AuthenticationController {

	@Value("${lgs.token.header}")
	private String tokenHeader;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping
	public String authenticatioRequest(@RequestBody LoginRequest loginRequest){
	Authentication authentication = this.authenticationManager.
			authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));	
	SecurityContextHolder.getContext().setAuthentication(authentication);
	UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getEmail());
	String token = this.tokenUtils.generateToken(userDetails);
	return token;
	}
}
