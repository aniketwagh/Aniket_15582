package com.ecom.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private Date orderdate;
	private String orderstatus;
	@OneToOne
	private Customer customer;
	@OneToMany
	private List<OrderItem> orderItems;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Date orderdate, String orderstatus, Customer customer, List<OrderItem> orderItems) {
		super();
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.customer = customer;
		this.orderItems = orderItems;
	}

	public Orders(long orderId, Date orderdate, String orderstatus, Customer customer, List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.customer = customer;
		this.orderItems = orderItems;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderdate=" + orderdate + ", orderstatus=" + orderstatus
				+ ", customer=" + customer + ", orderItems=" + orderItems + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
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
		Orders other = (Orders) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

}
