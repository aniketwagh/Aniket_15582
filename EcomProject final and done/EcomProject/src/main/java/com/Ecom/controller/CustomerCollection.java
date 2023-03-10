package com.Ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.Ecom.Dao.CustomerDao;
import com.Ecom.model.Customer;

public class CustomerCollection implements ICollection<Customer>{

	private static CustomerCollection collection;
	private CustomerDao dao;
	private List<Customer> customerList;
	
	private CustomerCollection() {
		this.dao = CustomerDao.getDao();
	}
	
	public static CustomerCollection getCustomerCollection() {
		if(collection==null) {
			synchronized (CustomerCollection.class) {
				if(collection==null) {
					collection=new CustomerCollection();
				}
			}
		}
		return collection;
	}

	public List<Customer> findAll() throws SQLException {
		customerList=dao.findAll();
		return customerList;
	}

	public Customer findOne(int id) throws SQLException {
		Customer customer = dao.findOne(id);
		return customer;
	}

	public boolean createNew(Customer t) throws SQLException {
		return dao.createNew(t);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		return dao.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Customer t) throws SQLException {
		return dao.findOneAndUpdate(id, t);
	}
}
