package com.Ecom.model;

public class ProductDetails {

	private int productid;
	private String productname;
	private String productdescription;
	private int quantity;
	public ProductDetails() {
		super();
	}
	public ProductDetails(String productname, String productdescription, int quantity) {
		super();
		this.productname = productname;
		this.productdescription = productdescription;
		this.quantity = quantity;
	}
	public ProductDetails(int productid, String productname, String productdescription, int quantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productdescription = productdescription;
		this.quantity = quantity;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductDetails [productid=" + productid + ", productname=" + productname + ", productdescription="
				+ productdescription + ", quantity=" + quantity + "]";
	}
	
	
}
