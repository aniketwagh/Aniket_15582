package com.ecom.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecom.dto.CustomerData;
import com.ecom.services.CustomerService;
@SpringBootTest
public class CustomerServiceTest {

	private CustomerData customerData;
	@Autowired
	private CustomerService customerService;
	@BeforeAll
	static void beforeAll() {
		System.out.println("****************************BeforeAll Methed****************************");
	}
	@BeforeEach
	public void beforeEach() {
		customerData = new CustomerData();
		customerData.setCustName("Sayli Dhonnar");
		customerData.setCustEmail("sd7@gmail.com");
		customerData.setCustAddress("Mumbai");
		System.out.println("****************************BeforeEachMethod****************************");
	}
//	@Disabled
	@Test
	public void testFindAllNotNull() {
		assertNotNull(customerService.findAll());
		System.out.println("****************************FindAllNotNullMethod****************************");
	}
	@Test
	public void testCreateNew() {
		assertNotNull(customerService.create(customerData));
		System.out.println("****************************CreateNewMethod****************************");
	}
//	@Disabled
	@Test
	public void testFindOneNotNull() {
		Long id = 8l;
		assertNotNull(customerService.findById(id));
		System.out.println("****************************FindOneNotNullMethod****************************");
	}
//	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Long id = 12l;
		assertTrue(customerService.delete(id));
		System.out.println("****************************FindOneAndDeleteMethod****************************");
	}
//	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		Long id = 8l;
		assertNotNull(customerService.update(id, customerData));
		System.out.println("****************************FindOneAndUpdateMethod****************************");
	}
}











