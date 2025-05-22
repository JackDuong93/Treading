package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	
	
}
