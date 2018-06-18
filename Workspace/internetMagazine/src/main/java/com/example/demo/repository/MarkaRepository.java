package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Marka;

public interface MarkaRepository extends JpaRepository<Marka, Long> {
	
	List<Marka> findMarkaByCategoryId(long id);

}
