package com.Ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.Ecom.model.Customer;

public class CustomerController implements IController<Customer> {

	private static CustomerController customercontroller;
	private CustomerCollection customercollection;
	public CustomerController() {
		super();
		this.customercollection = CustomerCollection.getCustomerCollection();
	}
	
	public static CustomerController getCustomerController() {
		if(customercontroller == null) {
			synchronized (CustomerController.class) {
				if(customercontroller == null) {
					customercontroller = new CustomerController();
				}
			}
		}
		return customercontroller;
	}

	public List<Customer> findAll() throws SQLException {
		return customercollection.findAll();
	}

	public Customer findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return customercollection.findOne(id);
	}

	public boolean createNew(Customer t) throws SQLException {
		// TODO Auto-generated method stub
		return customercollection.createNew(t);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return customercollection.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Customer t) throws SQLException {
		// TODO Auto-generated method stub
		return customercollection.findOneAndUpdate(id, t);
	}
	
	
}
