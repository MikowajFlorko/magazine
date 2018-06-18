package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Image;
import com.example.demo.request.GoodsRequest;
import com.example.demo.responce.GoodsResponce;

public interface ImageService {
	
	void save(Image image);
	Image findOne(long id);
	List<Image> findAll();
	void delete(long id);
	

}
