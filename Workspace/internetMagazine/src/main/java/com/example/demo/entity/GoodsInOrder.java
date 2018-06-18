package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GoodsInOrder {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Goods goods;
	@ManyToOne
	private PersonInOrder person;
	
	private int quantity;
	
	private Date date;
	
	public GoodsInOrder() {}
	
	public GoodsInOrder(Goods goods, PersonInOrder person, int quantity, Date date) {
		this.goods = goods;
		this.person = person;
		this.quantity = quantity;
		this.date = date;
	}

	public long getId() {
		return id;
	}
	public PersonInOrder getPerson() {
		return person;
	}

	public void setPerson(PersonInOrder person) {
		this.person = person;
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

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
