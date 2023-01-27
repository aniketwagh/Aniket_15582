//package com.ecom.test;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.ecom.dto.ProductData;
//import com.ecom.services.ProductService;
//@SpringBootTest
//public class ProductServiceTest {
//
////	@Autowired
//	private ProductData productData;
//	@Autowired
//	private ProductService productService;
//	@BeforeAll
//	static void beforeAll() {
//		System.out.println("BeforeAll Methed");
//	}
//	@BeforeEach
//	public void beforeEach() {
//		productData = new ProductData();
//		productData.setProductId(7L);
//		productData.setProductName("Nokia");
//		productData.setQuntity(17);
//		productData.setUnitPrice(16999);
//	}
//	
//	@Test
//	public void testFindAllNotNull() {
//		assertNotNull(productService.findAll());
//	}
//	
//	@Test
//	public void testCreateNew() {
//		assertNotNull(productService.create(productData));
//	}
//	@Test
//	public void testFindOneNotNull() {
//		Long id = 4l;
//		assertNotNull(productService.findById(id));
//	}
//	@Test
//	public void testFindOneAndDelete() {
//		Long id = 6l;
//		assertTrue(productService.delete(id));
//	}
//	@Test
//	public void testFindOneAndUpdate() {
//		Long id = 1l;
//		assertNotNull(productService.update(id, productData));
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
