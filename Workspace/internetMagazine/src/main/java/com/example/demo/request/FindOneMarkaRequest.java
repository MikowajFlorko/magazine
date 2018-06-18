package com.example.demo.request;

public class FindOneMarkaRequest {
	
	private Integer idMarka;
	
	public FindOneMarkaRequest() {}

	public FindOneMarkaRequest(Integer idMarka) {
		this.idMarka = idMarka;
	}
	public Integer getIdMarka() {
		return idMarka;
	}

	public void setIdMarka(Integer idMarka) {
		this.idMarka = idMarka;
	}
}
