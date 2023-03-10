package com.Ecom;

import java.sql.SQLException;
import java.util.List;

import com.Ecom.Dao.ProductDao;
import com.Ecom.controller.ProductController;
import com.Ecom.model.ProductDetails;

public class Product {

	public static void main(String[] args) {
		
		try {
			final ProductController productController = ProductController.getProductController();
			System.out.println("CURD Opration");
			int choice =1;
			System.out.println("1. Display all products");
			mainOptions(productController,choice);
			
			System.out.println("2. details products");
			choice=2;
			mainOptions(productController,choice);
			
			System.out.println("3. Delete products");
			choice=3;
			mainOptions(productController,choice);
			
			System.out.println("4. update products");
			choice=4;
			mainOptions(productController,choice);
			
			System.out.println("5. Create New products");
			choice=5;
			mainOptions(productController,choice);
			
			choice = 1;
			System.out.println("Display all Product");
			mainOptions(productController,choice);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void mainOptions(final ProductController productController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
				List<ProductDetails> list=productController.findAll();
				for(ProductDetails account:list) {
					System.out.println(account);
				}
				break;
		case 2: 
			final ProductDetails productdetails=productController.findOne(4);
			System.out.println(productdetails);
			break;
		case 3: 
			if(productController.findOneAndDelete(6)) {
				System.out.println("Product Deleted");
			}
			break;
		case 4: 
			final ProductDetails updatproduct=productController.findOne(6);
			updatproduct.setProductname("Samsung");
			if(productController.findOneAndUpdate(2,updatproduct)) {
				System.out.println("Product update" );
			}
			break;	
		case 5: 
			final ProductDetails newProduct=new ProductDetails("Nokia", "Nokia 2611",8) ;
			if(productController.createNew(newProduct)) {
				System.out.println(newProduct+ " Created in DB");
			}
			break;
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}
	
//	private static void printProduct(ProductDao dao) throws SQLException {
//		final List<ProductDetails> list=dao.findAll();
//		for(ProductDetails a: list) {
//			System.out.println(a);
//		}
//	}

}
