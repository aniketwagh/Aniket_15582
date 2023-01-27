package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private int quntity;
	private String productDescription;
	private String productImage;
	private double productPrice;
	private String productCategories;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productName, int quntity, String productDescription, String productImage, double productPrice,
			String productCategories) {
		super();
		this.productName = productName;
		this.quntity = quntity;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productCategories = productCategories;
	}
	public Product(Long productId, String productName, int quntity, String productDescription, String productImage,
			double productPrice, String productCategories) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quntity = quntity;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productCategories = productCategories;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategories() {
		return productCategories;
	}
	public void setProductCategories(String productCategories) {
		this.productCategories = productCategories;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quntity=" + quntity
				+ ", productDescription=" + productDescription + ", productImage=" + productImage + ", productPrice="
				+ productPrice + ", productCategories=" + productCategories + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
}
