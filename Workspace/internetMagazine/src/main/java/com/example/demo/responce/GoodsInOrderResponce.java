package com.example.demo.responce;

import java.util.Date;

import com.example.demo.entity.GoodsInOrder;

public class GoodsInOrderResponce {
	
	private long   id;
	private String name;
	private String surname;
	private String email;
	private int    phone;
	private String goodsMarka;
	private String goodsModel;
	private int    price;
	private int    quantity;
	private Date   date;
	
	
	public GoodsInOrderResponce() {	}
	public GoodsInOrderResponce(GoodsInOrder goodsInOrder) {
		this.id =        goodsInOrder.getId();
		this.name =      goodsInOrder.getPerson().getName();
		this.surname =   goodsInOrder.getPerson().getSurname();
		this.email =     goodsInOrder.getPerson().getEmail();
		this.phone =     goodsInOrder.getPerson().getPhone();
		this.goodsMarka =goodsInOrder.getGoods().getMarka().getMarka();
		this.goodsModel =goodsInOrder.getGoods().getModel();
		this.price =     goodsInOrder.getGoods().getPrice();
		this.quantity =  goodsInOrder.getQuantity();
		this.date =      goodsInOrder.getDate();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getGoodsMarka() {
		return goodsMarka;
	}
	public void setGoodsMarka(String goodsMarka) {
		this.goodsMarka = goodsMarka;
	}
	public String getGoodsModel() {
		return goodsModel;
	}
	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
 
}
