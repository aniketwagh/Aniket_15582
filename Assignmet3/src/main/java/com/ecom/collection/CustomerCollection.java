package com.ecom.collection;

import java.sql.SQLException;
import java.util.List;

import com.ecom.dao.CustomerDao;
import com.ecom.model.Customer;
public class CustomerCollection implements ICollection<Customer> {

	private static CustomerCollection customercollection;
	private List<Customer> customerList;
	private CustomerDao customerDao;
	
	
	public CustomerCollection() {
		super();
		this.customerDao = customerDao.getCustomerDao();
	}

	public static CustomerCollection getCustomerCollection() {
		if(customercollection == null) {
			synchronized (ProductCollection.class) {
				if(customercollection==null) {
					customercollection = new CustomerCollection();
				}
			}
		}
		return customercollection;
	}
	
	@Override
	public List<Customer> findAll() {
		
		customerList = customerDao.findAll();
		return customerList;
	}

	@Override
	public Customer findOne(int customerId) {
		
		Customer customer = customerDao.findOne(customerId);
		return customer;
	}

	@Override
	public boolean createNew(Customer customer) {
		
		return customerDao.createNew(customer);
	}

	@Override
	public boolean findOneAndDelete(int customerId) {
		
		return customerDao.findOneAndDelete(customerId);
	}

	@Override
	public boolean findOneAndUpdate(int customerId, Customer customer) {
		
		return customerDao.findOneAndUpdate(customerId, customer);
	}
}
