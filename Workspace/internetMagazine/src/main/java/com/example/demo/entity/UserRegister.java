package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserRegister implements UserDetails{	

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String password;
	private String surname;
	private int phone;
	private String city;
	private String email;
	private Role role;
	
	public UserRegister() {}
		
	public UserRegister(long id, String name, String password, String surname, int phone, String city, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.surname = surname;
		this.phone = phone;
		this.city = city;
		this.email = email;
	}

	public UserRegister(long id, String name, String password, String surname, int phone, String city, String email,
			Role role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.surname = surname;
		this.phone = phone;
		this.city = city;
		this.email = email;
		this.role = role;
	}



	public UserRegister(String name, String password, String surname, int phone, String city, String email, Role role) {
		this.name = name;
		this.password = password;
		this.surname = surname;
		this.phone = phone;
		this.city = city;
		this.email = email;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
