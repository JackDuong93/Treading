package com.jack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByUserId(Long userId);
	
}
