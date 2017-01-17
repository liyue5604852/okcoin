package com.okcoin.rest.service;

import com.okcoin.rest.stock.IStockRestApi;
import com.okcoin.rest.stock.impl.StockRestApi;

public class BaseService {
	
	static final String api_key = "54409af6-ece5-423d-86bb-45064abbdf1d";  //OKCoin申请的apiKey
	static final String secret_key = "3144FC5897AEE571A116FF8400E55A66";  //OKCoin 申请的secret_key
	static final String url_prex = "https://www.okcoin.cn";  //注意：请求URL 国际站https://www.okcoin.com ; 国内站https://www.okcoin.cn
	
	public IStockRestApi stockGet;
	public IStockRestApi stockPost;
	
	public BaseService(){
		stockGet = new StockRestApi(url_prex);
		stockPost = new StockRestApi(url_prex, api_key, secret_key);
	}
	
	
	public void test(){
		
	}

}
