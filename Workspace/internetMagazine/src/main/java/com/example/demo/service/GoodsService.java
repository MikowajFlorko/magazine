package com.example.demo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Goods;
import com.example.demo.request.FindOneCategoryRequest;
import com.example.demo.request.GoodsRequest;
import com.example.demo.responce.GoodsResponce;
import com.example.demo.responce.MarkaResponce;

public interface GoodsService {
	
	void save(Goods goods);
	Goods findOne(long id);
	List<Goods> findAll();
	void delete(long id);
	boolean deleteGoods(long id);
	Goods update(GoodsRequest goodsRequest);
	Map<Integer,GoodsResponce> findAllGoodsTwo();
	Goods createGoods(GoodsRequest goodsRequest) throws IOException;
	Map<Integer, GoodsResponce> findAllGoodsByCategory(long id);
	Map<Integer, GoodsResponce> findAllGoodsByMarka(long idMarka);
}
