package com.example.demo.request;

import java.util.Date;

public class GoodsInOrdersRequest {
	
	private long id;
	private String name;
	private String surname;
	private int phone;
	private String email;
	private long goodsId;
    private int  quantity;
	private Date date;
	
	public GoodsInOrdersRequest() {}

	public GoodsInOrdersRequest(String name, String surname, int phone, String email, long goodsId, int quantity, Date date) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.goodsId = goodsId;
		this.quantity = quantity;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
