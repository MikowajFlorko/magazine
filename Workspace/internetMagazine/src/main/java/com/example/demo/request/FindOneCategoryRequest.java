package com.example.demo.request;

public class FindOneCategoryRequest {
	
	private Integer id;

    public FindOneCategoryRequest() {}

	public FindOneCategoryRequest(Integer id) {
	this.id = id;
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
