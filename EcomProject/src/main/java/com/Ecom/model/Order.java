package com.Ecom.model;

public class Order {
	private int orderid;
	private String ordername;
	private int totalprice;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String ordername, int totalprice) {
		super();
		this.ordername = ordername;
		this.totalprice = totalprice;
	}
	public Order(int orderid, String ordername, int totalprice) {
		super();
		this.orderid = orderid;
		this.ordername = ordername;
		this.totalprice = totalprice;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", ordername=" + ordername + ", totalprice=" + totalprice + "]";
	}
	
	

}
