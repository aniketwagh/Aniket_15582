package com.ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecom.collection.CustomerCollection;
import com.ecom.model.Customer;
public class CustomerController  implements IController<Customer>{
	private static CustomerController customerController;
	private CustomerCollection customerCollection;

	private CustomerController() {
		super();
		this.customerCollection = customerCollection.getCustomerCollection();
	}
	
	public static CustomerController getCustomerController() {
		if(customerController == null) {
			synchronized (ProductController.class) {
				if(customerController == null) {
					customerController = new CustomerController();
				}
			}
		}
		return customerController;
	}
	
	@Override
	public List<Customer> findAll() {
		
		return customerCollection.findAll();
	}

	@Override
	public Customer findOne(int customerId) {
		
		return customerCollection.findOne(customerId);
	}

	@Override
	public boolean createNew(Customer customer) {
		
		return customerCollection.createNew(customer);
	}

	@Override
	public boolean findOneAndDelete(int customerId) {
		
		return customerCollection.findOneAndDelete(customerId);
	}

	@Override
	public boolean findOneAndUpdate(int customerId, Customer customer) {
		
		return customerCollection.findOneAndUpdate(customerId, customer);
	}
}
