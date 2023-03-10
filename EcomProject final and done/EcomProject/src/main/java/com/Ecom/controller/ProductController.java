package com.Ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.Ecom.model.ProductDetails;

public class ProductController implements IController<ProductDetails> {
	
	private static ProductController productcontroller;
	private ProductCollection productcollection;
	public ProductController() {
		super();
		this.productcollection = ProductCollection.getProductCollection();
	}
	
	public static ProductController getProductController() {
		if(productcontroller == null) {
			synchronized (ProductController.class) {
				if(productcontroller == null) {
					productcontroller = new ProductController();
				}
			}
		}
		return productcontroller;
	}

	public List<ProductDetails> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return productcollection.findAll();
	}

	public ProductDetails findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return productcollection.findOne(id);
	}

	public boolean createNew(ProductDetails t) throws SQLException {
		// TODO Auto-generated method stub
		return productcollection.createNew(t);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return productcollection.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, ProductDetails t) throws SQLException {
		// TODO Auto-generated method stub
		return productcollection.findOneAndUpdate(id, t);
	}

}
