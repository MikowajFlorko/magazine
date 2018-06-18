package com.example.demo.responce;

import com.example.demo.entity.Goods;

public class GoodsResponce {
	
	private long id;
	private String marka;
	private String model;
	private String category;
	private int price;
	private String image;
	
	public GoodsResponce() {}

	public GoodsResponce(Goods goods) {
		this.id = goods.getId();
		this.marka = goods.getMarka().getMarka();
		this.model = goods.getModel();
		this.price = goods.getPrice();
		this.image = goods.getImage().getName();
		this.category = goods.getCategory().getName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
