package com.example.demo.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class PersonInOrder{
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String surname;
	private int phone;
	private String email;
	
	@OneToMany(mappedBy = "person")
	private List<GoodsInOrder> goodsInOrder;
	
	public PersonInOrder() {}
	
	public PersonInOrder(String name, String surname, int phone, String email) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<GoodsInOrder> getGoodsInOrder() {
		return goodsInOrder;
	}

	public void setGoodsInOrder(List<GoodsInOrder> goodsInOrder) {
		this.goodsInOrder = goodsInOrder;
	}
	
}
