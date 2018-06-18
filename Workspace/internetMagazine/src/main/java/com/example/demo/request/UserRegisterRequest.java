package com.example.demo.request;

public class UserRegisterRequest {
private long id;
	
	private String name;
	private String surname;
	private int phone;
	private String city;
	private String email;
	
	public UserRegisterRequest() {}

	public UserRegisterRequest(String name, String surname, int phone, String city, String email) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.city = city;
		this.email = email;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
