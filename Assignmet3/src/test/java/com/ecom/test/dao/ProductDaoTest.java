package com.ecom.test.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecom.dao.ProductDao;
import com.ecom.model.Product;

public class ProductDaoTest {

	private Product product;
	private ProductDao productDao;

	@BeforeEach()
	public void beforeEach() {
		product = new Product("Realme 10 Pro +", 26000);
		productDao = new ProductDao();
	}

//	@Disabled
	@Test
	public void testCreateProduct() {
		Assertions.assertTrue(productDao.createNew(product));
	}
	
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productDao.findAll());
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		product = productDao.findOne(1);
		Assertions.assertNotNull(product);
		System.out.println("id=1 |" + product);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productDao.findOneAndDelete(2));
	}
	
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		product.setProudctName("Nokia");
		Assertions.assertTrue(productDao.findOneAndUpdate(1, product));
	}
}
