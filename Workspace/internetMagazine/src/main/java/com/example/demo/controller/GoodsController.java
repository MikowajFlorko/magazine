package com.example.demo.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.entity.Goods;
import com.example.demo.request.FindOneCategoryRequest;
import com.example.demo.request.FindOneGoodsRequest;
import com.example.demo.request.FindOneMarkaRequest;
import com.example.demo.responce.CategoryResponce;
import com.example.demo.responce.GoodsResponce;
import com.example.demo.responce.MarkaResponce;
import com.example.demo.service.CategoryService;
import com.example.demo.service.GoodsService;
import com.example.demo.service.MarkaService;

@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MarkaService markaService;
	 
	@GetMapping
	public Goods findOne(long id) {
		return goodsService.findOne(id);
	}
	@GetMapping("/allGoods")
	public Map<Integer, GoodsResponce> findAllGoodsTwo(){
		return goodsService.findAllGoodsTwo();
	}
	@PostMapping("/findOne")
	public Goods findGoods(@RequestBody FindOneGoodsRequest request) {
		return goodsService.findOne(request.getId());
	}
	@PostMapping("/findCategory")
	public Category findCategory(@RequestBody FindOneCategoryRequest request) {
		return categoryService.findOne(request.getId());		
	}
	@GetMapping("/findAllCategory")
	public Map<Integer, CategoryResponce> findAllCategory (){
		return categoryService.findAllCategory();
	}
	@PostMapping("/findGoodsByCategory")
	public Map<Integer, GoodsResponce> findGoodsByCategory (@RequestBody FindOneCategoryRequest request) throws IOException{
		return goodsService.findAllGoodsByCategory(request.getId());
	}
	
	@GetMapping("/findAllMarka")
	public Map<Integer, MarkaResponce> findsAllMarka () throws IOException {
		return markaService.findAllMarka();
	}
	@PostMapping("/findMarkaByCategory")
	public Map<Integer, MarkaResponce> findMarkaByCategory(@RequestBody FindOneCategoryRequest request) throws IOException {
		return markaService.findMarkaByCategory(request.getId());
	}
	@PostMapping("/findGoodsByMarka")
	public Map<Integer, GoodsResponce> findGoodsByMarka (@RequestBody FindOneMarkaRequest request) throws IOException{
		return goodsService.findAllGoodsByMarka(request.getIdMarka());
	}

}
