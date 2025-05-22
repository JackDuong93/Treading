package com.jack.service;

import java.util.List;

import com.jack.domain.OrderType;
import com.jack.model.Coin;
import com.jack.model.Order;
import com.jack.model.OrderItem;
import com.jack.model.User;

public interface OrderService {
	
	Order createOrder(User user, OrderItem orderItem, OrderType orderType);
	
	Order getOrderById(Long orderId) throws Exception;
	
	List<Order> getAllOrdersOfUsers(Long userId,OrderType orderType,String assetSymbol);

	Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;
	
	
}
