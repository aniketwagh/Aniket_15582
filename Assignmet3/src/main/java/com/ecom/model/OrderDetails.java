package com.ecom.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private Date date;
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToMany(mappedBy = "orderDetails", cascade = CascadeType.ALL)
	private List<Cart> cartList = new ArrayList<>();
	public OrderDetails() {
		super();
	}
	
	public OrderDetails(Date date, Customer customer) {
		super();
		this.date = date;
		this.customer = customer;
	}


	public OrderDetails(Date date, Customer customer, List<Cart> cartList) {
		super();
		this.date = date;
		this.customer = customer;
		this.cartList = cartList;
	}
	public OrderDetails(int orderId, Date date, Customer customer, List<Cart> cartList) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.customer = customer;
		this.cartList = cartList;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Cart> getCartList() {
		return cartList;
	}
	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", date=" + date + ", customer=" + customer + ", cartList="
				+ cartList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	

}
