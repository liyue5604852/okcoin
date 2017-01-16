package com.okcoin.rest.bean;

import java.io.IOException;

import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.rest.stock.IStockRestApi;
import com.okcoin.rest.stock.impl.StockRestApi;

public class Stock {
	
	static final String api_key = "54409af6-ece5-423d-86bb-45064abbdf1d";  //OKCoin申请的apiKey
	static final String secret_key = "3144FC5897AEE571A116FF8400E55A66";  //OKCoin 申请的secret_key
	static final String url_prex = "https://www.okcoin.cn";  //注意：请求URL 国际站https://www.okcoin.com ; 国内站https://www.okcoin.cn
	
	IStockRestApi stockGet;
	IStockRestApi stockPost;
	
	//当前价格
	double currentPrz;
	//上次成交价格
	double lastPrz;
	//交易状态
	String dealStatus = "buy";
	
	public Stock(){
		stockGet = new StockRestApi(url_prex);
		stockPost = new StockRestApi(url_prex, api_key, secret_key);
	}

	public double getCurrentPrz() {
		try {
			String info = stockGet.ticker("btc_cny");
			System.out.println(info);
			JSONObject infoObj = (JSONObject) JSON.parse(info);
			JSONObject tickerObj = (JSONObject) infoObj.get("ticker");
			currentPrz = Double.parseDouble(tickerObj.get("last").toString());
		} catch (HttpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentPrz;
	}
	
}
