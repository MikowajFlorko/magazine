package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GoodsInOrder;
import com.example.demo.request.GoodsInOrdersRequest;
import com.example.demo.service.GoodsInOrderService;


@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private GoodsInOrderService goodsInOrderService;
	
	@PutMapping
	public GoodsInOrder createOrser(@RequestBody GoodsInOrdersRequest goodsInOrdersRequest) {
		return goodsInOrderService.createOrder(goodsInOrdersRequest);
	}
	
}
