package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Goods;
import com.example.demo.entity.GoodsInOrder;
import com.example.demo.entity.PersonInOrder;
import com.example.demo.repository.GoodsInOrderRepository;
import com.example.demo.repository.GoodsRepository;
import com.example.demo.repository.PersonInOrderRepository;
import com.example.demo.request.GoodsInOrdersRequest;
import com.example.demo.responce.GoodsInOrderResponce;
import com.example.demo.responce.GoodsResponce;
import com.example.demo.service.GoodsInOrderService;

@Service
public class GoodsInOrderServiceImpl implements GoodsInOrderService{

	@Autowired
	private GoodsInOrderRepository goodsInOrderRepository;
	@Autowired
	private GoodsRepository goodsRepository;
	@Autowired
	private PersonInOrderRepository personRepository;	
	@Override
	public void save(GoodsInOrder goodsInOrder) {
		goodsInOrderRepository.save(goodsInOrder);
	}

	@Override
	public GoodsInOrder findOne(long id) {
		return goodsInOrderRepository.findOne(id);
	}

	@Override
	public List<GoodsInOrder> findAll() {
		return goodsInOrderRepository.findAll();
	}
	@Override
	public GoodsInOrder createOrder(GoodsInOrdersRequest goodsInOrdersRequest) {
		Date date = new Date();
		Goods findGoods = goodsRepository.findOne(goodsInOrdersRequest.getGoodsId());
		PersonInOrder person = new PersonInOrder(goodsInOrdersRequest.getName(), goodsInOrdersRequest.getSurname(), goodsInOrdersRequest.getPhone(), goodsInOrdersRequest.getEmail());
		GoodsInOrder order = new GoodsInOrder(findGoods, person, goodsInOrdersRequest.getQuantity(), date);
		personRepository.save(person);
		goodsInOrderRepository.save(order);
		return goodsInOrderRepository.save(order);
	}
//	@Override
//	public GoodsInOrder createOrder(GoodsInOrdersRequest goodsInOrdersRequest) {
//		Date date = new Date();
//		Goods findGoods = goodsRepository.findOne(goodsInOrdersRequest.getGoodsId());
//		Person person = new Person(goodsInOrdersRequest.getName(), goodsInOrdersRequest.getSurname(), goodsInOrdersRequest.getPhone(), goodsInOrdersRequest.getEmail());
//		GoodsInOrder order = new GoodsInOrder(findGoods, person, goodsInOrdersRequest.getQuantity(), date);
//		personRepository.save(person);
//		goodsInOrderRepository.save(order);
//		return goodsInOrderRepository.save(order);
//	}

	private GoodsInOrderResponce convert(GoodsInOrder goodsInOrders) {
		return new GoodsInOrderResponce(goodsInOrders);		
	}
	@Override
	public List<GoodsInOrderResponce> findAllGoods() {
		List<GoodsInOrder> findAll = goodsInOrderRepository.findAll();
		List<GoodsInOrderResponce> us = new ArrayList();
		for (GoodsInOrder goodsInOrders : findAll) {
		GoodsInOrderResponce response = convert(goodsInOrders);
		us.add(response);
	}
		return us;
}
	@Override
	public boolean deleteGoodsInOrder(long id) {
		PersonInOrder findPerson = personRepository.findOne(id);
		goodsInOrderRepository.delete(id);
		personRepository.delete(findPerson);
		return true;
	}

}
