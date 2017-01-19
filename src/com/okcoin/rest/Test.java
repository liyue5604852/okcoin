package com.okcoin.rest;

import com.okcoin.rest.bean.Order;
import com.okcoin.rest.bean.Stock;
import com.okcoin.rest.service.DealLogic;
import com.okcoin.rest.service.OrderService;
import com.okcoin.rest.service.StockService;

public class Test {
	Order order = new Order();

	public static void main(String[] args) {
		/*DealLogic logic = DealLogic.getInstance();
		logic.init();
		logic.start();*/
		
		StockService service = new StockService();
		System.out.println("end=====" + service.getCurrentPrz());
		
		/*Stock stock = new Stock();
		
		double dealPrz;
		String dealStatus;
		double currentPrz;
		
		if(order.getStatus() == 2){
			dealPrz = order.getPrice();
			currentPrz = stock.getCurrentPrz();
			if("buy".equals(order.getStatus()) && currentPrz - dealPrz > 1){
    			System.out.println("=====sell=====" + stock.getCurrentPrz());
    			stock.setDealStatus("empty");
    			stock.setLastPrz(stock.getCurrentPrz());
    		}else if("empty".equals(stock.getDealStatus()) && stock.getLastPrz() - stock.getCurrentPrz() > 1){
    			System.out.println("=====buy=====" + stock.getCurrentPrz());
    			stock.setDealStatus("fill");
    			stock.setLastPrz(stock.getCurrentPrz());
    		}
		}*/
		
		
		
		
		/*Stock stock = new Stock();
		Boolean tradeResult = stock.buy("5000", "0.01");
		System.out.println(tradeResult);*/
		
	}
}
