package com.example.demo.request;

public class FindOneGoodsRequest {
	
private Integer id;

    public FindOneGoodsRequest() {}

	public FindOneGoodsRequest(Integer id) {
	this.id = id;
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

