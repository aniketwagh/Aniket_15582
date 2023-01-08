package com.training.customer.controller;

import java.sql.SQLException;
import java.util.List;


import com.training.customer.dao.ProductDao;
import com.training.customer.model.Product;

public class ProductCollection implements ICollection<Product> {

	private static ProductCollection collection;
	private ProductDao productdao;
	private List<Product> productList;
	
	public static ProductCollection getProductCollection() {
		if(collection==null) {
			synchronized (ProductCollection.class) {
				if(collection==null) {
					collection=new ProductCollection();
				}
				
			}
		}
		return collection;
	}
	@Override
	public List<Product> findAll() throws SQLException {
		productList=productdao.findAll();
		return productList;
	}
	@Override
	public Product findOne(int id) throws SQLException {
		Product product = productdao.findOne(id);
		return product;
	}
	@Override
	public boolean createNew(Product t) throws SQLException {
		return productdao.createNew(t);
	}
	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return productdao.findOneandDelete(id);
	}
	@Override
	public boolean findOneAndUpdate(int id, Product t) throws SQLException {
		return productdao.findOneandUpdate(id, t);
	}
	
	
}
