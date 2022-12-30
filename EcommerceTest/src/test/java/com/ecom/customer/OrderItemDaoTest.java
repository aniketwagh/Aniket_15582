package com.ecom.customer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.training.customer.dao.OrderItemDao;
import com.training.customer.dao.ProductDao;
import com.training.customer.model.OrderItem;
import com.training.customer.model.Product;

public class OrderItemDaoTest {
	
	private OrderItem orderitem;
	private OrderItemDao orderitemdao;
	private Product product;
	private ProductDao productdao;
	@BeforeEach()
	public void beforeEach() {
		productdao = new ProductDao();
		product = productdao.findOne(29);
		orderitem = new OrderItem(product , 5);
		orderitemdao = new OrderItemDao();
	}
	
//	@Disabled
	@Test
	public void testcreateNew() {
		Assertions.assertTrue(orderitemdao.createNew(orderitem));
	}
	
//	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productdao.findAll());
	}
	
//	@Disabled
	@Test
	public void testFindOneNotNull() {
		product=productdao.findOne(1);
		Assertions.assertNotNull(product);
		System.out.println("id=2 |"+product);
	}
	
//	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productdao.findOneandDelete(2));
	}

//	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		product.setProductName("LG");
		Assertions.assertTrue(productdao.findOneandUpdate(4, product));
	}
}
