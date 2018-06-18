package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonInOrder;
import com.example.demo.repository.PersonInOrderRepository;
import com.example.demo.request.PersonInOrderRequest;
import com.example.demo.service.PersonInOrderService;

@Service
public class PersonInOrderServiceImpl implements PersonInOrderService {

	@Autowired
	private PersonInOrderRepository personRepository;
	
	@Override
	public void save(PersonInOrder person) {
		personRepository.save(person);			
	}

	@Override
	public PersonInOrder findOne(long id) {
		return personRepository.findOne(id);
	}

	@Override
	public List<PersonInOrder> findAll() {
		return personRepository.findAll();
	}
	
//	@Override
//	public Person register (PersonRequest personRequest) {
//		Person findEmail = personRepository.findByEmail(personRequest.getEmail());
//		if(findEmail == null) {
//		Person person = new Person(personRequest.getName(), personRequest.getSurname(), personRequest.getDateBorn(), personRequest.getEmail());
//		personRepository.save(person);
//		return personRepository.save(person);
//		}else{
//			throw new IllegalArgumentException("Login or password is incorrect");
//		}		
//	}

	@Override
	public PersonInOrder findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

}
