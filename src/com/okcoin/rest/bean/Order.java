package com.okcoin.rest.bean;

public class Order {
	
	//order ID
	private String orderId;
	//order amoumt
	private double amount;
	//order price
	private double price;
	//order status(-1:已撤销  0:未成交  1:部分成交  2:完全成交 4:撤单处理中)
	private int status;
	//order type(buy sell)
	private String type;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
