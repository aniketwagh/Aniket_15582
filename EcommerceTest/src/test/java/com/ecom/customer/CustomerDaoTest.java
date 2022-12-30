package com.ecom.customer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.customer.dao.CustomerDao;
import com.training.customer.model.Customer;

public class CustomerDaoTest {

	
	private Customer customer;
	private CustomerDao customerDao;
	
	@BeforeEach()
	public void beforeEach() {
		customer=new Customer("Akanksha Satkar");
		customerDao=new CustomerDao();
	}
	
//	@Disabled
	@Test
	public void testcreateCustomer() {
		Assertions.assertTrue(customerDao.createNew(customer));
	}
	
//	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(customerDao.findAll());
	}
	
//	@Disabled
	@Test
	public void testFindOneNotNull() {
		customer=customerDao.findOne(28);
		Assertions.assertNotNull(customer);
		System.out.println("id=28 "+customer);
	}
	
//	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneandDelete(28));
	}
	
//	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		customer.setCustName("Aniket");
		Assertions.assertTrue(customerDao.findOneandUpdate(31, customer));
	}
}
