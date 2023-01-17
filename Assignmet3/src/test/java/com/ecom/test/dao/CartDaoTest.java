package com.ecom.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecom.dao.CartDao;
import com.ecom.model.Cart;
import com.ecom.model.OrderDetails;
import com.ecom.model.Product;

public class CartDaoTest {

	private Cart cart;
	private CartDao cartDao;

	@BeforeEach()
	public void beforeEach() {
		Product product = new Product(1, "Realme 10 pro +", 28000);
		OrderDetails orderDetails = new OrderDetails();
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		cart = new Cart(28, 12445, product, orderDetails);
		cartDao = new CartDao();
		cartDao.createNew(cart);
	}
	
//	@Disabled
	@Test
	public void testCreateCartItems() {
		Assertions.assertTrue(cartDao.createNew(cart));
	}

	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(cartDao.findAll());
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		cart = cartDao.findOne(1);
		Assertions.assertNotNull(cart);
		System.out.println("id=1 |" + cart);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(cartDao.findOneAndDelete(2));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		cart.setQuantity(5);
		Assertions.assertTrue(cartDao.findOneAndUpdate(1, cart));
	}
}
