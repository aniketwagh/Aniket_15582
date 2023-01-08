package com.training.customer.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderItemId;
 	@OneToOne(cascade = CascadeType.ALL)
    private Product product;
 	private int quantity;
    private double total;
    @ManyToOne
    private Orders orders;
	public OrderItem() {
		super();
	}
	public OrderItem(Product product, int quantity, double total) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.total = total;
	}
	public OrderItem(int orderItemId, Product product, int quantity, double total, Orders orders) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.quantity = quantity;
		this.total = total;
		this.orders = orders;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", product=" + product + ", quantity=" + quantity + ", total="
				+ total + ", orders=" + orders + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderItemId;
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		OrderItem other = (OrderItem) obj;
		if (orderItemId != other.orderItemId)
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
}
