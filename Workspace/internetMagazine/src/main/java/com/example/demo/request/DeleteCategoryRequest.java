package com.example.demo.request;

public class DeleteCategoryRequest {
	
	private long id;

	public DeleteCategoryRequest(long id) {
		this.id = id;
	}

	public DeleteCategoryRequest() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
