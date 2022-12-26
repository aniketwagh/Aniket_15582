package com.ecom.model;

public class Order {
	private int orderId;
	private String orderName;
	private int price;
	private static int counter=1;
	public Order() {
		super();
	}
	public Order(String orderName, int price) {
		super();
		this.orderName = orderName;
		this.price = price;
	}
	public Order(int orderId, String orderName, int price) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.price = price;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", price=" + price + "]";
	}
	
}