package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.GoodsInOrder;
import com.example.demo.request.GoodsInOrdersRequest;
import com.example.demo.responce.GoodsInOrderResponce;

public interface GoodsInOrderService {
	
	void save (GoodsInOrder goodsInOrder);
	GoodsInOrder findOne(long id);
	List <GoodsInOrder> findAll();
	GoodsInOrder createOrder(GoodsInOrdersRequest goodsInOrdersRequest);
    List<GoodsInOrderResponce> findAllGoods();
	boolean deleteGoodsInOrder(long id);
}
