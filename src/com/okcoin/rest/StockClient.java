package com.okcoin.rest;

import java.io.IOException;

import org.apache.http.HttpException;


import com.alibaba.fastjson.JSONObject;
import com.okcoin.rest.bean.Stock;
import com.okcoin.rest.stock.IStockRestApi;
import com.okcoin.rest.stock.impl.StockRestApi;

/**
 * 现货 REST API 客户端请求
 * @author zhangchi
 *
 */
public class StockClient {

	public static void main(String[] args) throws HttpException, IOException{
		Stock stock = new Stock();
		
		String api_key = "54409af6-ece5-423d-86bb-45064abbdf1d";  //OKCoin申请的apiKey
		String secret_key = "3144FC5897AEE571A116FF8400E55A66";  //OKCoin 申请的secret_key
		String url_prex = "https://www.okcoin.cn";  //注意：请求URL 国际站https://www.okcoin.com ; 国内站https://www.okcoin.cn
	    
	
	   
		
	    
		
	    //现货用户信息
	    System.out.println(stock.getCurrentPrz());
//		
//	    //现货下单交易
//	    String tradeResult = stockPost.trade("btc_usd", "buy", "50", "0.02");
//	    System.out.println(tradeResult);
//	    JSONObject tradeJSV1 = JSONObject.parseObject(tradeResult);
//	    String tradeOrderV1 = tradeJSV1.getString("order_id");
//
//	    //现货获取用户订单信息
//            stockPost.order_info("btc_usd", tradeOrderV1);
//		
//	    //现货撤销订单
//	    stockPost.cancel_order("btc_usd", tradeOrderV1);
//		
//	    //现货批量下单
//	    stockPost.batch_trade("btc_usd", "buy", "[{price:50, amount:0.02},{price:50, amount:0.03}]");
//
//	    //批量获取用户订单
//	    stockPost.orders_info("0", "btc_usd", "125420341, 125420342");
//		
//	    //获取用户历史订单信息，只返回最近七天的信息
//	    stockPost.order_history("btc_usd", "0", "1", "20");
		
		
	}
}
