package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Category;
import com.example.demo.responce.CategoryResponce;

public interface CategoryService  {
	
	void save (Category category);
	Category findOne(long id);
	boolean delete(long id);
	Category findByName(String name);
	Category createCategory(CategoryResponce categoryResponce);
	Map<Integer, CategoryResponce> findAllCategory();
	
}
