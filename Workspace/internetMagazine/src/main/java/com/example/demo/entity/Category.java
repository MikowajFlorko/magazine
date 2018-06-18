package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	private String name;
    
	@JsonIgnore
	@OneToMany(mappedBy="category")	
	private List<Goods> goods;
	
	@JsonIgnore
	@OneToMany(mappedBy="category")	
	private List<Marka> marka;

	public Category(long id, List<Goods> goods, String name) {
		this.id = id;
		this.goods = goods;
		this.name = name;
	}
		
	public Category(long id, String name, List<Marka> marka) {
		this.id = id;
		this.name = name;
		this.marka = marka;
	}


	public Category(String name) {
		this.name = name;
	}
	public Category() {}

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

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public List<Marka> getMarka() {
		return marka;
	}

	public void setMarka(List<Marka> marka) {
		this.marka = marka;
	}
		
}
