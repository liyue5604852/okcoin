package com.okcoin.rest.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.rest.bean.Order;

public class OrderService extends BaseService{
	/**
	 * 更新订单
	 * @param Order
	 * @return Order
	 */
	public Order refreshOrder(Order order){
		return getOrderById(order);
	}
	
	/**
	 * 买入
	 * @param prz
	 * @param amount
	 * @return order_id
	 */
	public String buy(String prz ,String amount){
		String orderId = null;
		try {
			String returnInfo = stockPost.trade("btc_cny", "buy", prz, amount);
			Map<String, Object> returnMap = transformTrade(returnInfo);
			orderId = returnMap.get("orderId").toString();
		} catch (HttpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderId;
	}
	public String sell(String prz ,String amount){
		String orderId = null;
		try {
			String returnInfo = stockPost.trade("btc_cny", "sell", prz, amount);
			Map<String, Object> returnMap = transformTrade(returnInfo);
			orderId = returnMap.get("orderId").toString();
		} catch (HttpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderId;
	}
	
	private Map<String, Object> transformTrade(String tradeMsg){
		Map<String, Object> tradeRtnInfoMap = new HashMap<String, Object>();
		JSONObject tradeMsgObj = JSON.parseObject(tradeMsg);
		String orderId = tradeMsgObj.getString("order_id");
		boolean result = tradeMsgObj.getBooleanValue("result");
		
		tradeRtnInfoMap.put("orderId", orderId);
		tradeRtnInfoMap.put("result", result);
		return tradeRtnInfoMap;
	}
	
	private Order getOrderById(Order order){
		try {
			long starTime=System.currentTimeMillis();
			String returnInfo = stockPost.order_info("btc_cny", order.getOrderId());
			long endTime=System.currentTimeMillis();
//			System.out.println(returnInfo);
			long Time=endTime-starTime;
//			System.out.println(starTime);
//			System.out.println(endTime);
//			System.out.println(Time);
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
		String orderId = orderObj.getString("order_id");
		System.out.println(orderId);
		order.setStatus(status);
		order.setPrice(price);
		order.setType(type);
		order.setOrderId(orderId);
		return order;
	}
	
	public Order clearOrder(){
		return new Order();
	}
}
