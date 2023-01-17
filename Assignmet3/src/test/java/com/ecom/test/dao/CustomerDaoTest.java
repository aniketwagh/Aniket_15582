package com.ecom.test.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecom.dao.CustomerDao;
import com.ecom.model.Customer;

public class CustomerDaoTest {

	private Customer customer;
	private CustomerDao customerDao;

	@BeforeEach()
	public void beforeEach() {
		
		customer = new Customer("Aniket", 703097735, "Nagpur");
		customerDao = new CustomerDao();
	}
	
//	@Disabled
	@Test
	public void testCreateCustomer() {
		Assertions.assertTrue(customerDao.createNew(customer));
	}

	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(customerDao.findAll());
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		customer = customerDao.findOne(3);
		Assertions.assertNotNull(customer);
		System.out.println("id=1 |" + customer);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneAndDelete(2));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		customer.setCustomerName("Pranay");
		Assertions.assertTrue(customerDao.findOneAndUpdate(2, customer));
	}
}
