package com.example.demo.request;

public class GoodsRequest {
	
	private long id;
	private long marka;
	private String model;
	private int price;
	private long categoryId;
	private String imageName;
		
	public GoodsRequest() {}

	public GoodsRequest(long id, long marka, String model , int price, long categoryId, String imageName) {
		this.id = id;
		this.model = model;
		this.marka = marka;
		this.price = price;
		this.categoryId = categoryId;
		this.imageName = imageName;
	}

	public GoodsRequest(long marka, String model, int price) {
		this.marka = marka;
		this.model = model;
		this.price = price;
	}
	
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}	

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMarka() {
		return marka;
	}

	public void setMarka(long marka) {
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
