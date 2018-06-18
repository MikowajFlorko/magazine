package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PersonInOrder;
import com.example.demo.request.PersonInOrderRequest;

public interface PersonInOrderService {
	
	void save(PersonInOrder person);
	PersonInOrder findOne(long id);
	List<PersonInOrder> findAll();
//	Person register(PersonRequest personRequest);
	PersonInOrder findByEmail (String email);

}
