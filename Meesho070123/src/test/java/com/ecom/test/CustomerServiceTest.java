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
		System.out.println("BeforeAll Methed");
	}
	@BeforeEach
	public void beforeEach() {
		customerData = new CustomerData();
		customerData.setCustId(1L);
		customerData.setCustName("Aniket Waghmare");
		customerData.setCustEmail("waghmareaniket7@gmail.com");
		customerData.setCustAddress("Nagpur");
	}
	@Disabled
	@Test
	public void testFindAllNotNull() {
		assertNotNull(customerService.findAll());
	}
	@Test
	public void testCreateNew() {
		assertNotNull(customerService.create(customerData));
	}
	@Disabled
	@Test
	public void testFindOneNotNull() {
		Long id = 4l;
		assertNotNull(customerService.findById(id));
	}
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Long id = 3l;
		assertTrue(customerService.delete(id));
	}
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		Long id = 2l;
		assertNotNull(customerService.update(id, customerData));
	}
}











