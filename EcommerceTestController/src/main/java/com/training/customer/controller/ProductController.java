package com.training.customer.controller;


import java.sql.SQLException;
import java.util.List;

import com.training.customer.model.Product;

public class ProductController implements IController<Product>{
	
	private static ProductController productcontroller;
	private ProductCollection productcollection;
	public ProductController() {
		super();
		this.productcollection = ProductCollection.getProductCollection();
		// TODO Auto-generated constructor stub
	}public static ProductController getProductController() {
		if(productcontroller == null) {
			synchronized (ProductController.class) {
				if(productcontroller == null) {
					productcontroller = new ProductController();
				}
			}
		}
		return productcontroller;
	}
	@Override
	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return productcontroller.findAll();
	}
	@Override
	public Product findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return productcontroller.findOne(2);
	}
	@Override
	public boolean createNew(Product p) throws SQLException {
		// TODO Auto-generated method stub
		return productcontroller.createNew(p);
	}
	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return productcontroller.findOneAndDelete(4);
	}
	@Override
	public boolean findOneAndUpdate(int id, Product t) throws SQLException {
		// TODO Auto-generated method stub
		return productcontroller.findOneAndUpdate(id, t);
	}
	
	

}
