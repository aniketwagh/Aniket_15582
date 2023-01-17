package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String proudctName;
	private double unitPrice;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String proudctName, double unitPrice) {
		super();
		this.proudctName = proudctName;
		this.unitPrice = unitPrice;
	}
	public Product(int productId, String proudctName, double unitPrice) {
		super();
		this.productId = productId;
		this.proudctName = proudctName;
		this.unitPrice = unitPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProudctName() {
		return proudctName;
	}
	public void setProudctName(String proudctName) {
		this.proudctName = proudctName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", proudctName=" + proudctName + ", unitPrice=" + unitPrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	
	
}
