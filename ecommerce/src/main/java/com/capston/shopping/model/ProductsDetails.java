package com.capston.shopping.model;

public class ProductsDetails extends Exception{
	private static int counter=1;
	private int product_id;
	private String Product_name;
	protected double price;
	public ProductsDetails() {
		super();
	}
	public ProductsDetails(String product_name, double price) {
		super();
		this.product_id = counter++;
		Product_name = product_name;
		this.price = price;
	}
	public ProductsDetails(int product_id, String product_name, double price) {
		super();
//		this.product_id = counter++;
		Product_name = product_name;
		this.price = price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", Product_name=" + Product_name + ", price=" + price + "]";
	}
	
}
