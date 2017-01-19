package com.okcoin.rest.service;

import com.okcoin.rest.bean.Order;
import com.okcoin.rest.bean.Stock;

public class DealLogic {
	
	private static DealLogic instance = new DealLogic();
	
	private static Order order = new Order();
	private OrderService orderService = new OrderService();
	private StockService stockService = new StockService();
	
	private static double currentPrz;
	private static String orderId;
	
	private DealLogic(){
		
	}
	
	public static DealLogic getInstance(){
		return instance;
	}
	
	public void init(){
		currentPrz = stockService.getCurrentPrz();
		System.out.println("start===" + currentPrz);
		orderId = orderService.buy(currentPrz, 0.17);
		order.setOrderId(orderId);
		order = orderService.refreshOrder(order);
	}
	
	public void start(){
		currentPrz = stockService.getCurrentPrz();
		System.out.println(currentPrz);
		if(order.getStatus() == 2){	//订单完全成交
			if("buy".equals(order.getType()) && currentPrz - order.getPrice() > 1.2){
				System.out.println("====sell====" + currentPrz +" - " + order.getPrice() + " = " + (currentPrz - order.getPrice()));
				orderId = orderService.sell(currentPrz, 0.17);
			}else if("sell".equals(order.getType()) && order.getPrice() - currentPrz > 1.2){
				System.out.println("====buy====" + order.getPrice() +" - " + currentPrz + " = " + (currentPrz - order.getPrice()));
				orderId = orderService.buy(currentPrz, 0.17);
			}
			order.setOrderId(orderId);
		}
		order = orderService.refreshOrder(order);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
