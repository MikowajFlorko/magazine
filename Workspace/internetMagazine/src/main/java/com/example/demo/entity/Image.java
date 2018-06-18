package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	public Image(String name) {
		this.name = name;
	}
	
	public Image(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Image() {
		super();
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
