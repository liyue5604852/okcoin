package com.okcoin.rest;

import com.okcoin.rest.bean.Stock;
import com.okcoin.rest.service.OrderService;

public class Test {

	public static void main(String[] args) {
		OrderService service = new OrderService();
		service.refreshOrder(order);
		
		
		
		
		Stock stock = new Stock();
		Boolean tradeResult = stock.buy("5000", "0.01");
		System.out.println(tradeResult);
		
	}
}
