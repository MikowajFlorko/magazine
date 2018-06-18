package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Goods;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.responce.CategoryResponce;
import com.example.demo.responce.GoodsResponce;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category findOne(long id) {
		return categoryRepository.findOne(id);
	}
	private CategoryResponce convert(Category category) {
		return new CategoryResponce(category);		
	}

	@Override
	public Map<Integer, CategoryResponce> findAllCategory() {	
	List<Category> findAll = categoryRepository.findAll();
	Map<Integer,CategoryResponce> us = new HashMap<>();
	for (Category category : findAll) {
	CategoryResponce response = convert(category);
	us.put((int) response.getId(), response);
}
	return us;
}
	@Override
	public boolean delete(long id) {
		categoryRepository.delete(id);;
		return false;
	}

	@Override
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}
	@Override
	public Category createCategory (CategoryResponce categoryResponce) {
		Category category1 = new Category(categoryResponce.getName());
		return categoryRepository.save(category1);		
	}
	
}
