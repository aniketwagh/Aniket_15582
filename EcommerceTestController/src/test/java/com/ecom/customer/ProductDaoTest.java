package com.ecom.customer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.training.customer.dao.ProductDao;
import com.training.customer.model.Product;

public class ProductDaoTest {

	
	private Product product;
	private ProductDao productdao;
	
	@BeforeEach()
	public void beforeEach() {
		product=new Product("Realme 10 pro +", 26068);
		productdao=new ProductDao();
	}
	
//	@Disabled
	@Test
	public void testcreateNew() {
		Assertions.assertTrue(productdao.createNew(product));
	}
	
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productdao.findAll());
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		product=productdao.findOne(1);
		Assertions.assertNotNull(product);
		System.out.println("id=2 |"+product);
	}
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productdao.findOneandDelete(2));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		product.setProductName("LG");
		Assertions.assertTrue(productdao.findOneandUpdate(4, product));
	}
}
