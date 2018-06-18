package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Marka;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MarkaRepository;
import com.example.demo.request.MarkaRequest;
import com.example.demo.responce.MarkaResponce;
import com.example.demo.service.MarkaService;

@Service
public class MarkaServiceImpl implements MarkaService {
	
	@Autowired
	private MarkaRepository markaRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void save(Marka marka) {
		markaRepository.save(marka);
		
	}

	@Override
	public Marka findOne(long id) {
		return markaRepository.findOne(id);
	}

	@Override
	public List<Marka> findAll() {
		return markaRepository.findAll();
	}

	
	private MarkaResponce convert(Marka marka) {
		return new MarkaResponce(marka);		
	}

	@Override
	public Marka createMarka (MarkaRequest markaRequest) {
		Category category = categoryRepository.findOne(markaRequest.getCategory());
		Marka marka = new Marka(markaRequest.getName(), category);
		return markaRepository.save(marka);
}
	@Override
	public Map<Integer, MarkaResponce> findAllMarka() {
		List<Marka> findAll = markaRepository.findAll();
		Map<Integer,MarkaResponce> us = new HashMap<>();
		for (Marka marka: findAll) {
		MarkaResponce response = convert(marka);
		us.put((int) response.getId(), response);
	}
		return us;
}
	@Override
	public boolean delete(long id) {
		markaRepository.delete(id);
		return false;
	}

	@Override
	public Map<Integer, MarkaResponce> findMarkaByCategory(long id) {
		List<Marka> findAll = markaRepository.findMarkaByCategoryId(id);
		Map<Integer,MarkaResponce> us = new HashMap<>();
		for (Marka marka: findAll) {
		MarkaResponce response = convert(marka);
		us.put((int) response.getId(), response);
	}
		return us;
}
	}
