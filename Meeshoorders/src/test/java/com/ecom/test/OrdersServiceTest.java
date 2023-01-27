//package com.ecom.test;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.ecom.dto.OrdersData;
//import com.ecom.model.Customer;
//import com.ecom.model.OrderItem;
//import com.ecom.model.Product;
//import com.ecom.services.OrdersService;
//
//@SpringBootTest
//public class OrdersServiceTest {
//
////	@Autowired
//	private OrdersData ordersData;
//	@Autowired
//	private OrdersService ordersService;
//	private Date date;
//
//	@BeforeAll
//	static void beforeAll() {
//		System.out.println("BeforeAll Methed");
//	}
//
//	@BeforeEach
//	public void beforeEach(Customer id,OrderItem id1) {
//		ordersData = new OrdersData();
//		ordersData.setOrderId(1l);
//		ordersData.setDate(date);
//		ordersData.setCustomer(id);
////		ordersData.setOrderItemList(orderItemList);
//	}
//
//	@Test
//	public void testFindAllNotNull() {
//		assertNotNull(ordersService.findAll());
//	}
//
//	@Test
//	public void testCreateNew() {
//		assertNotNull(ordersService.createNew(ordersData));
//	}
//
//	@Test
//	public void testFindOneNotNull() {
//		Long id = 4l;
//		assertNotNull(ordersService.findById(id));
//	}
//
//	@Test
//	public void testFindOneAndDelete() {
//		Long id = 6l;
//		assertTrue(ordersService.deleteById(id));
//	}
//
//	@Test
//	public void testFindOneAndUpdate() {
//		Long id = 1l;
//		assertNotNull(ordersService.updateById(id, ordersData));
//	}
//}
