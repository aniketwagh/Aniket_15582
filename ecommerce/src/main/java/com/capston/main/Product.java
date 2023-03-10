package com.capston.main;

import com.capston.shopping.model.ProductsDetails;
import com.capston.shopping.model.ProductsList;
import com.capston.shopping.util.ProductNotFoundExeption;

public class Product {

	public static void main(String[] args) {
		try {
			System.out.println("Display All Products");
			ProductsDetails [] info = ProductsList.getInfo();
			extracted(info);
			String product_name="Mi";
			int product_id=4;
			ProductsDetails pd = findByProductName(info, product_name, product_id);
			if(pd!=null) {
				System.out.println("Product Id is " +product_id + " And Product Name is " + product_name);
			}
			else
			{
				System.out.println("Not in a list");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static ProductsDetails findByProductName(ProductsDetails[] info, String product_name, int product_id) {
		for(ProductsDetails pd : info) {
			if(pd.getProduct_name() == product_name && pd.getProduct_id() == product_id)
			{
				return pd;
//				throw new ProductNotFoundExeption("Product not found");
			} 
		}
		return null;
	}
	private static void extracted(ProductsDetails[] infos) {
		for (ProductsDetails pd : infos) {
			System.out.println(pd);
		}
	}
}