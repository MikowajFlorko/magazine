package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Marka;
import com.example.demo.request.DeleteCategoryRequest;
import com.example.demo.request.DeleteGoodsInOrdersRequest;
import com.example.demo.request.DeleteGoodsRequest;
import com.example.demo.request.DeleteMarkaRequest;
import com.example.demo.request.FindOneCategoryRequest;
import com.example.demo.request.FindOneGoodsRequest;
import com.example.demo.request.FindOneMarkaRequest;
import com.example.demo.request.GoodsRequest;
import com.example.demo.request.MarkaRequest;
import com.example.demo.responce.CategoryResponce;
import com.example.demo.responce.GoodsInOrderResponce;
import com.example.demo.responce.GoodsResponce;
import com.example.demo.responce.MarkaResponce;
import com.example.demo.service.CategoryService;
import com.example.demo.service.GoodsInOrderService;
import com.example.demo.service.GoodsService;
import com.example.demo.service.MarkaService;


@CrossOrigin
@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class AdminController {
	
	@Autowired
	private GoodsService        goodsService;
	@Autowired
	private GoodsInOrderService goodsInOrderService;
	@Autowired
	private CategoryService     categoryService;
	@Autowired
	private MarkaService     markaService;
	
	@PutMapping("/createGoods")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Goods createGoods(@RequestBody GoodsRequest goodsRequest) throws IOException {
		return goodsService.createGoods(goodsRequest);		
	}
	
	@GetMapping("/allGoods")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Map<Integer, GoodsResponce> findAllGoodsTwo(){
		return goodsService.findAllGoodsTwo();
	}
	
	@GetMapping("/allOrders")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<GoodsInOrderResponce> findAllOrders(){
		return goodsInOrderService.findAllGoods();
	}
	@DeleteMapping("/deleteGoods")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean deleteGoods(@RequestBody DeleteGoodsRequest request){
		return goodsService.deleteGoods(request.getId());
  }
	@DeleteMapping("/deleteOrders")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean deleteGoodsInOrders(@RequestBody DeleteGoodsInOrdersRequest request) {
		return goodsInOrderService.deleteGoodsInOrder(request.getId());
	}
	@DeleteMapping("/deleteCategory")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean deleteCategoty(@RequestBody DeleteCategoryRequest request) {
		return categoryService.delete(request.getId());
	}
	@DeleteMapping("/deleteMarka")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean deleteMarka(@RequestBody DeleteMarkaRequest request) {
		return markaService.delete(request.getId());
	}	
	@PostMapping("/findOne")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Goods findGoods(@RequestBody FindOneGoodsRequest request) {
		return goodsService.findOne(request.getId());
	}
	@PostMapping("/updateGoods")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Goods findGoods(@RequestBody GoodsRequest request) {
		return goodsService.update(request);
	}
	@PostMapping("/findCategory")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Category findCategory(@RequestBody FindOneCategoryRequest request) {
		return categoryService.findOne(request.getId());		
	}
	@GetMapping("/findAllCategory")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Map<Integer, CategoryResponce> findAllCategory (){
		return categoryService.findAllCategory();
	}
	@PutMapping("/createCategory")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Category createCategory(@RequestBody CategoryResponce categoryResponce) {
		return categoryService.createCategory(categoryResponce);		
	}
	@PostMapping("/findGoodsByCategory")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Map<Integer, GoodsResponce> findGoodsByCategory (@RequestBody FindOneCategoryRequest request) throws IOException{
		return goodsService.findAllGoodsByCategory(request.getId());
	}
	
	@GetMapping("/findAllMarka")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Map<Integer, MarkaResponce> findsAllMarka () throws IOException {
		return markaService.findAllMarka();
	}
	@PutMapping("/createMarka")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Marka createMarka(@RequestBody MarkaRequest markaRequest) {
		return markaService.createMarka(markaRequest);		
	}
	@PostMapping("/findMarkaByCategory")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Map<Integer, MarkaResponce> findMarkaByCategory(@RequestBody FindOneCategoryRequest request) throws IOException {
		return markaService.findMarkaByCategory(request.getId());
	}
	@PostMapping("/findGoodsByMarka")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Map<Integer, GoodsResponce> findGoodsByMarka (@RequestBody FindOneMarkaRequest request) throws IOException{
		return goodsService.findAllGoodsByMarka(request.getIdMarka());
	}
}