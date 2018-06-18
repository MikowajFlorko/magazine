package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Goods {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Marka marka;
	
	private String model;
	
	private int price;
	
	@OneToOne
	private Image image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "goods")
	private List<GoodsInOrder> goodsInOrders;
	
	@ManyToOne
	private Category category;
	
	public Goods() {}
	
	public Goods(Marka marka, int price, String model, Category category, Image image) {
		this.marka = marka;
		this.price = price;
		this.category = category;
		this.model = model;
		this.image = image;
	}
	
	public Goods(Marka marka, String model, int price, List<GoodsInOrder> goodsInOrders, Category category,
			Image image) {
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.price = price;
		this.goodsInOrders = goodsInOrders;
		this.category = category;
		this.image = image;
	}

	public List<GoodsInOrder> getGoodsInOrders() {
		return goodsInOrders;
	}
	public void setGoodsInOrders(List<GoodsInOrder> goodsInOrders) {
		this.goodsInOrders = goodsInOrders;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

		public Marka getMarka() {
		return marka;
	}

	public void setMarka(Marka marka) {
		this.marka = marka;
	}

		public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", marka=" + marka + ", model=" + model + ", price=" + price + ", goodsInOrders="
				+ goodsInOrders + ", category=" + category + "]";
	}	
	
}
