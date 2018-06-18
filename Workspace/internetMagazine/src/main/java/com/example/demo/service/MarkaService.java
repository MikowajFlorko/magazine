package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Marka;
import com.example.demo.request.MarkaRequest;
import com.example.demo.responce.MarkaResponce;

public interface MarkaService {
	
	void save(Marka marka);
	Marka findOne(long id);
	List<Marka> findAll();
	boolean delete(long id);
	Map<Integer, MarkaResponce> findAllMarka();
	Marka createMarka(MarkaRequest markaRequest);
	Map<Integer, MarkaResponce> findMarkaByCategory(long id);	
	
}
