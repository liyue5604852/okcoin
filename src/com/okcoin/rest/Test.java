package com.okcoin.rest;

import com.okcoin.rest.bean.Stock;

public class Test {

	public static void main(String[] args) {
		Stock stock = new Stock();
		
		
		Boolean tradeResult = stock.buy("5000", "0.01");
		System.out.println(tradeResult);
		
	}
}
