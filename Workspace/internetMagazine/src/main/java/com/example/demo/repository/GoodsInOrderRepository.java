package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GoodsInOrder;

public interface GoodsInOrderRepository extends JpaRepository<GoodsInOrder, Long> {

}
