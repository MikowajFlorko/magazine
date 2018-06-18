package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PersonInOrder;

public interface PersonInOrderRepository extends JpaRepository<PersonInOrder, Long> {
	
	PersonInOrder findByEmail (String email);

}
