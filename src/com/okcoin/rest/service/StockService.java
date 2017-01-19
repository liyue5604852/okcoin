package com.okcoin.rest.service;

import java.io.IOException;

import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.rest.bean.Stock;

public class StockService extends BaseService {

	public double getCurrentPrz() {
		double currentPrz = 0;
		try {
			String rtnInfo = stockGet.ticker("btc_cny");
			Stock stock = transfromStock(rtnInfo);
			currentPrz = stock.getPrice();
		} catch (HttpException | IOException e) {
			e.printStackTrace();
		}
		return currentPrz;
	}
	
	private Stock transfromStock(String stockMsg){
		Stock stock = new Stock();
		
		JSONObject stockMsgObj = JSON.parseObject(stockMsg);
		JSONObject tickObj = stockMsgObj.getJSONObject("ticker");
		
		stock.setPrice(tickObj.getDoubleValue("last"));
		return stock;
	}
	
}
