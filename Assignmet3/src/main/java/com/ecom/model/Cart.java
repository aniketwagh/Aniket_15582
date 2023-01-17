package com.ecom.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int quantity;
	private double totalItemPrice;
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	@ManyToOne
	private OrderDetails orderDetails;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int quantity, double totalItemPrice, Product product, OrderDetails orderDetails) {
		super();
		this.quantity = quantity;
		this.totalItemPrice = totalItemPrice;
		this.product = product;
		this.orderDetails = orderDetails;
	}
	public Cart(int cartId, int quantity, double totalItemPrice, Product product, OrderDetails orderDetails) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.totalItemPrice = totalItemPrice;
		this.product = product;
		this.orderDetails = orderDetails;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalItemPrice() {
		return totalItemPrice;
	}
	public void setTotalItemPrice(double totalItemPrice) {
		this.totalItemPrice = totalItemPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", totalItemPrice=" + totalItemPrice + ", product="
				+ product + ", orderDetails=" + orderDetails + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
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
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}
	
	
}
