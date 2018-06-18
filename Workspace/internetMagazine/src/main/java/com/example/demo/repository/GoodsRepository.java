package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Marka;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
	
	List<Goods> findGoodsByCategoryId(long id);
	List<Goods> findGoodsByMarkaId(long id);
}
