package com.example.demo.request;

public class FindOneUserRegisterRequest {
	
	private Long id;

	
	public FindOneUserRegisterRequest() {}

	public FindOneUserRegisterRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
