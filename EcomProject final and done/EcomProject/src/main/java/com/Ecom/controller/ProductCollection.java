package com.Ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.Ecom.Dao.ProductDao;
import com.Ecom.model.ProductDetails;

public class ProductCollection implements ICollection<ProductDetails> {
	
	private static ProductCollection collection;
	private ProductDao dao;
	private List<ProductDetails> productList;
	
	private ProductCollection() {
		this.dao = ProductDao.getDao();
	}
	
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

	public List<ProductDetails> findAll() throws SQLException {
		productList=dao.findAll();
		return productList;
	}

	public ProductDetails findOne(int id) throws SQLException {
		
		ProductDetails productdetails = dao.findOne(id);
		return productdetails;
	}

	public boolean createNew(ProductDetails t) throws SQLException {
	
		return dao.createNew(t);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
	
		return dao.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, ProductDetails t) throws SQLException {
		
		return dao.findOneAndUpdate(id, t);
	}

}
