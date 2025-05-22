package com.jack.request;

import com.jack.domain.OrderType;

import lombok.Data;

@Data
public class CreateOrderRequest {

	private String coinId;
	private double quantity;
	private OrderType orderType;
}
