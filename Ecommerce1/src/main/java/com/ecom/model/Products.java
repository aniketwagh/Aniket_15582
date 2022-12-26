package com.ecom.model;

public class Products {
 private static int counter=1;
	private int productId;
	public String productName;
	public Products() {
		super();
	}
	public Products(String productName) {
		super();
		this.productId=counter++;
		this.productName = productName;
	}
	public Products(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + "]";
	}
	
}
