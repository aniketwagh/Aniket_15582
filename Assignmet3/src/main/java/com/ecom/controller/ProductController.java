package com.ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecom.collection.ProductCollection;
import com.ecom.controller.IController;
import com.ecom.model.Product;

public class ProductController implements IController<Product> {

	private static ProductController productController;
	private ProductCollection productCollection;

	public ProductController() {
		super();
		this.productCollection = productCollection.getProductCollection();
	}
	
	public static ProductController getProductController() {
		if(productController == null) {
			synchronized (ProductController.class) {
				if(productController == null) {
					productController = new ProductController();
				}
			}
		}
		return productController;
	}
	
	@Override
	public List<Product> findAll() {
		
		return productCollection.findAll();
	}

	@Override
	public Product findOne(int productId) {
		
		return productCollection.findOne(productId);
	}

	@Override
	public boolean createNew(Product product) {
		
		return productCollection.createNew(product);
	}

	@Override
	public boolean findOneAndDelete(int productId) {
		
		return productCollection.findOneAndDelete(productId);
	}

	@Override
	public boolean findOneAndUpdate(int productId, Product product) {
		
		return productCollection.findOneAndUpdate(productId, product);
	}

}
