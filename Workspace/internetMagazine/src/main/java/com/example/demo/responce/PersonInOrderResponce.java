package com.example.demo.responce;

import com.example.demo.entity.PersonInOrder;

public class PersonInOrderResponce {
	
	private long id;
	private String name;
	private String surname;
	private int phone;
	private String email;
	
	public PersonInOrderResponce(PersonInOrder person) {
		this.id = person.getId();
		this.name = person.getName();
		this.surname = person.getSurname();
		this.phone = person.getPhone();
		this.email = person.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
