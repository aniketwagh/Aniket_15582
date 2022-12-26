package com.ecom.main;

import java.util.Set;

import com.ecom.dao.ProductCollection;
import com.ecom.model.Products;

public class ProductsDetails {

	public static void main(String[] args) {
		
		ProductCollection pc = ProductCollection.getCollection();
		Set<Products> p = pc.getList();
		System.out.println("!================Disply all Records================!");
		p.add(new Products("Nokia"));
		p.add(new Products("Samsung"));
		p.add(new Products("Realme"));
		for(Products p1 : p)
		{
			System.out.println(p1);
		}	
		System.out.println("!=================Find By Id Records================!");
		System.out.println(pc.findById(3));
		System.out.println("!=================Updaet Product By Id==============!");
		System.out.println(pc.updatebyId(new Products("vivo"), 3));
		System.out.println("!=================Add New Product===================!");
		System.out.println(pc.createNewProduct(new Products("vivo")));
		
	}
}
