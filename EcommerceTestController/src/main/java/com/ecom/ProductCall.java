package com.ecom;

import java.sql.SQLException;
import java.util.List;
import com.training.customer.controller.ProductController;
import com.training.customer.model.Product;




public class ProductCall {

	public static void main(String[] args) throws SQLException {
		try {
			final ProductController productController = ProductController.getProductController();
			System.out.println("CURD Opration");
//			int choice =1;
			System.out.println("1. Display all Customers");

			List<Product> list= productController.findAll();
			for(Product p : list) {
				System.out.println(p);				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
