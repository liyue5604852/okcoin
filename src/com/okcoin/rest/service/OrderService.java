package com.okcoin.rest.service;

import java.io.IOException;

import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.rest.bean.Order;

public class OrderService extends BaseService{

	public Order refreshOrder(Order order){
		
		return getOrderById(order.getOrderId());
	}
	
	private Order getOrderById(String orderId){
		try {
			String returnInfo = stockPost.order_info("btc_cny", orderId);
			System.out.println(orderInfo);
			
		} catch (HttpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Order transformOrder(String jsonMsg){
		JSONObject  = JSON.parseObject(jsonMsg);
		return null;
	}
}
