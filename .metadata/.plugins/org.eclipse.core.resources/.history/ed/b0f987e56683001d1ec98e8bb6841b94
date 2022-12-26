package com.ecom.dao;

import java.util.Set;
import com.ecom.model.Products;
import com.meeshoappcollection.MeeshoCollection;

public class ProductCollection extends MeeshoCollection<Products>{

	private static ProductCollection pc;
	public ProductCollection() {
		super();
	}

	//Singleton object creation
	public static ProductCollection getCollection() {
		if(pc==null) {
			synchronized(ProductCollection.class) {
				if(pc==null) {
					pc = new ProductCollection();
				}
			}
		}
		return pc;
	}

	@Override
	public Set<Products> getList() {
		return collection;
	}

	@Override
	public String createNewProduct(Products productName) {
		if(collection.add(productName)) {
			return "New Product Added";

		}
		return null;
	}

	@Override
	public String updatebyId(Products entity, int Id) {
		for(Products product:collection) {
			if(product.getProductId()==Id) {
				product.setProductName(entity.getProductName());
				return "Product updated Successfully";
			}	
		}
		return null;
	}

	@Override
	public Products findById(int Id) {
		for(Products product:collection) {
			if(product.getProductId()==Id) {
				return product;
			} 
		}
		return null;
	}

	@Override
	public String deleteById(int Id) {
		for(Products product:collection) {
			if(product.getProductId()==Id) {
				collection.remove(product);
				return "Product Deleted";
			}
		}
		return "Product Not Found";
	}
}


//linke no 46
//product.setProductQuantity(entity.getProductQuantity());
//product.setProductDescription(entity.getProductDescription());
//product.setProductSize(entity.getProductSize());
//product.setProductPrice(entity.getProductPrice());
//product.setProductImage(entity.getProductImage());