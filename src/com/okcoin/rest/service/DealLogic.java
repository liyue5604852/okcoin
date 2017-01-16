package com.okcoin.rest.service;

public class DealLogic {
	
	private static DealLogic instance = new DealLogic();
	
	private DealLogic(){
		
	}
	
	public static DealLogic getInstance(){
		return instance;
	}

}
