package com.okcoin.rest.service;

import com.okcoin.rest.bean.Order;

public class DealLogic {
	
	private static DealLogic instance = new DealLogic();
	
	private static Order order;
	private static Order lastOrder;
	private OrderService service = new OrderService();
	
	private DealLogic(){
		
	}
	
	public static DealLogic getInstance(){
		return instance;
	}
	
	public void init(){
		order = new Order();
		order.setOrderId("-1");
		order = service.refreshOrder(order);
	}
	
	public void start(){
		if(order.getStatus() == 2){	//订单完全成交
			if("sell".equals(order.getType())){
			}else if("buy".equals(order.getType())){
				
			}
			System.out.println("done");
		}else {						//订单未完全成交
			order = service.refreshOrder(order);
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
