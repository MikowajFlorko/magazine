package com.example.demo.responce;

import com.example.demo.entity.Marka;

public class MarkaResponce {
	
	private long id;
	private String name;
	private String category;
		
	public MarkaResponce() {}
	
	public MarkaResponce(Marka marka) {
		this.id = marka.getId();
		this.name = marka.getMarka();
		this.category = marka.getCategory().getName();
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
