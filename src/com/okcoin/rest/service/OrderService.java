package com.okcoin.rest.service;

import java.io.IOException;

import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.rest.bean.Order;

public class OrderService extends BaseService{

	public Order refreshOrder(Order order){
		
		return getOrderById(order);
	}
	
	private Order getOrderById(Order order){
		try {
			String returnInfo = stockPost.order_info("btc_cny", order.getOrderId());
			System.out.println(returnInfo);
			order = transformOrder(order, returnInfo);
			
		} catch (HttpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
	private Order transformOrder(Order order, String jsonMsg){
		JSONObject jsonMsgObj = JSON.parseObject(jsonMsg);
		JSONArray ordersObj = jsonMsgObj.getJSONArray("orders");
		JSONObject orderObj = ordersObj.getJSONObject(0);
		int status = orderObj.getIntValue("status");
		double price = orderObj.getDoubleValue("price");
		String type = orderObj.getString("type");
		order.setStatus(status);
		order.setPrice(price);
		order.setType(type);
		return order;
	}
}
