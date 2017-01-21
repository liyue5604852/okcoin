package com.okcoin.rest.service;

import org.apache.log4j.Logger;

import com.okcoin.rest.bean.Order;
import com.okcoin.rest.bean.Stock;

public class DealLogic {
	private static Logger logger = Logger.getLogger(DealLogic.class);
	
	private static DealLogic instance = new DealLogic();
	
	//交易数量
	private static final double DEAL_AMOUMT = 0.17;
	//交易差额
	private static final double GAP_PRICE = 1.5;
	
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
		orderId = orderService.buy(currentPrz, DEAL_AMOUMT);
		logger.warn("===buy===" + currentPrz);
		order.setOrderId(orderId);
		order = orderService.refreshOrder(order);
	}
	
	public void start(){
		currentPrz = stockService.getCurrentPrz();
		logger.info(currentPrz);
		if(order.getStatus() == 2){	//订单完全成交
			if("buy".equals(order.getType()) && currentPrz - order.getPrice() > GAP_PRICE){
				logger.warn("===sell===" + currentPrz +" - " + order.getPrice() + " = " + (currentPrz - order.getPrice()));
				orderId = orderService.sell(currentPrz, DEAL_AMOUMT);
			}else if("sell".equals(order.getType()) && order.getPrice() - currentPrz > GAP_PRICE){
				logger.warn("===buy===" + order.getPrice() +" - " + currentPrz + " = " + (order.getPrice() - currentPrz));
				orderId = orderService.buy(currentPrz, DEAL_AMOUMT);
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
