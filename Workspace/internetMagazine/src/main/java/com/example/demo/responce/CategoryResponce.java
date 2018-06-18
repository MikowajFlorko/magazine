package com.example.demo.responce;

import com.example.demo.entity.Category;

public class CategoryResponce {
	
	private long id;
	private String name;

	public CategoryResponce() {}

	public CategoryResponce(Category category) {
		this.id = category.getId();
		this.name = category.getName();
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
	
	
}
