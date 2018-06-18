package com.example.demo.request;

public class MarkaRequest {
	
	private long id;
	private String name;
	private long category ;
	
	public MarkaRequest() {}
	
	public MarkaRequest(String name, long category) {
		super();
		this.name = name;
		this.category = category;
	}



	public MarkaRequest(long id, String name, long category) {
		this.id = id;
		this.name = name;
		this.category = category;
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
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}	

}
