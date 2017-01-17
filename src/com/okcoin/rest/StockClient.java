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
		
		final long timeInterval = 1000;  
        Runnable runnable = new Runnable() {  
            public void run() {  
                while (true) {  
            		if("fill".equals(stock.getDealStatus()) && stock.getCurrentPrz() - stock.getLastPrz() > 1){
            			System.out.println("=====sell=====" + stock.getCurrentPrz());
            			stock.setDealStatus("empty");
            			stock.setLastPrz(stock.getCurrentPrz());
            		}else if("empty".equals(stock.getDealStatus()) && stock.getLastPrz() - stock.getCurrentPrz() > 1){
            			System.out.println("=====buy=====" + stock.getCurrentPrz());
            			stock.setDealStatus("fill");
            			stock.setLastPrz(stock.getCurrentPrz());
            		}
            		System.out.println(stock.getCurrentPrz());
                    try {  
                        Thread.sleep(timeInterval);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        };  
        Thread thread = new Thread(runnable);  
        thread.start();

		
		
		
		
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
