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
	
	static Boolean dealFlag;
	
	private IStockRestApi stockGet;
	private IStockRestApi stockPost;
	
	//当前价格
	private double currentPrz;
	//上次成交价格
	private double lastPrz = 5000;
	//交易状态
	private String dealStatus = "fill";
	
	public Stock(){
		stockGet = new StockRestApi(url_prex);
		stockPost = new StockRestApi(url_prex, api_key, secret_key);
	}
	
	public boolean buy(String prz, String amount){
		try {
			String returnInfo = stockPost.trade("btc_cny", "buy", prz, amount);
			System.out.println(returnInfo);
			JSONObject returnInfoObj = JSON.parseObject(returnInfo);
			dealFlag = (Boolean) returnInfoObj.get("result");
		} catch (HttpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealFlag;
	}

	public double getCurrentPrz() {
		try {
			String info = stockGet.ticker("btc_cny");
			JSONObject infoObj = (JSONObject) JSON.parse(info);
			JSONObject tickerObj = (JSONObject) infoObj.get("ticker");
			currentPrz = Double.parseDouble(tickerObj.get("last").toString());
		} catch (HttpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentPrz;
	}

	public String getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public double getLastPrz() {
		return lastPrz;
	}

	public void setLastPrz(double lastPrz) {
		this.lastPrz = lastPrz;
	}

	public IStockRestApi getStockGet() {
		return stockGet;
	}

	public void setStockGet(IStockRestApi stockGet) {
		this.stockGet = stockGet;
	}

	public IStockRestApi getStockPost() {
		return stockPost;
	}

	public void setStockPost(IStockRestApi stockPost) {
		this.stockPost = stockPost;
	}
	
	
	
}
