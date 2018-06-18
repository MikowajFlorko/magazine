package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Marka {
	

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	private String marka;
	
	@JsonIgnore
	@ManyToOne	
	private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy="marka")	
	private List<Goods> goods;

	public Marka() {}
	
	public Marka(String marka) {
		this.marka = marka;
	}
	
	public Marka(long id, String marka, Category category) {
		super();
		this.id = id;
		this.marka = marka;
		this.category = category;
	}

	public Marka(String marka, Category category) {
		super();
		this.marka = marka;
		this.category = category;
	}

	public Marka(String marka, List<Goods> goods) {
		this.marka = marka;
		this.goods = goods;
	}

	public Marka(long id, String marka, List<Goods> goods) {
		this.id = id;
		this.marka = marka;
		this.goods = goods;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
}
