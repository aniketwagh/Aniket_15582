package com.ecom.test.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecom.dao.OrderDetailsDao;
import com.ecom.model.Cart;
import com.ecom.model.Customer;
import com.ecom.model.OrderDetails;
import com.ecom.model.Product;

public class OrderDetailsDaoTest {

	private OrderDetails orderDetails;
	private OrderDetailsDao orderDetailsDao;

	@BeforeEach()
	public void beforeEach() {
		Product product = new Product(1, "Samsung", 15999.00);
		Cart cart = new Cart(1, 12, 20000.00, product, orderDetails);
		List<Cart> cartList = new ArrayList<>();
		cartList.add(cart);
		
		
		orderDetails = new OrderDetails(new Date(), new Customer("Aniket", 70309773, "Nagpur"),cartList);
		orderDetailsDao = new OrderDetailsDao();
		orderDetailsDao.createNew(orderDetails);
		
	}
	
//	@Disabled
	@Test
	public void testCreateOrderDetails() {
		Assertions.assertTrue(orderDetailsDao.createNew(orderDetails));
	}

	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(orderDetailsDao.findAll());
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		orderDetails = orderDetailsDao.findOne(1);
		Assertions.assertNotNull(orderDetails);
		System.out.println("id=1 |" + orderDetails);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(orderDetailsDao.findOneAndDelete(3));
	}
}
