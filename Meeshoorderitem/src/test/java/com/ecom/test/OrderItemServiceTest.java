//package com.ecom.test;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.ecom.dto.OrderItemData;
//import com.ecom.model.Product;
//import com.ecom.services.OrderItemService;
//
//@SpringBootTest
//public class OrderItemServiceTest {
//
////	@Autowired
//	private OrderItemData orderItemData;
//	@Autowired
//	private OrderItemService orderItemService;
//
//	@BeforeAll
//	static void beforeAll() {
//		System.out.println("BeforeAll Methed");
//	}
//
//	@BeforeEach
//	public void beforeEach(Product id) {
//		orderItemData = new OrderItemData();
//		orderItemData.setOrderItemId(2L);
//		orderItemData.setQuntity(2);
//		orderItemData.setProduct(id);
//	}
//
//	@Test
//	public void testFindAllNotNull() {
//		assertNotNull(orderItemService.findAll());
//	}
//
//	@Test
//	public void testCreateNew() {
//		assertNotNull(orderItemService.createNew(orderItemData));
//	}
//
//	@Test
//	public void testFindOneNotNull() {
//		Long id = 4l;
//		assertNotNull(orderItemService.findById(id));
//	}
//
//	@Test
//	public void testFindOneAndDelete() {
//		Long id = 6l;
//		assertTrue(orderItemService.deleteById(id));
//	}
//
//	@Test
//	public void testFindOneAndUpdate() {
//		Long id = 1l;
//		assertNotNull(orderItemService.updateById(id, orderItemData));
//	}
//}
