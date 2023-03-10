package com.ecom.dao;

import java.util.Set;

import com.ecom.model.Customer;
import com.meeshoappcollection.MeeshoCollection;

public class CustomerCollection extends MeeshoCollection<Customer>{

	private static CustomerCollection cc;

	public CustomerCollection() {
		super();
	}
	public static CustomerCollection getCollection(){
		if(cc == null){
			synchronized (CustomerCollection.class) {
				if(cc == null){
					cc = new CustomerCollection();
				}
			}
		}
		return cc;
	}
	@Override
	public Set getList() {
		return collection;
	}
	@Override
	public String createNewCustomer(Customer custName) {
		if(collection.add(custName)) {
			return "Add New Customer";
		}
		return null;
	}
	@Override
	public String updatebyId(Object entity, int Id) {
		for(Customer customer : collection) {
			if(customer.getCustId()==Id) {
				customer.setCustName(customer.getCustName());
				customer.setCustEmail(customer.getCustEmail());
				customer.setPhoneNo(customer.getPhoneNo());
				customer.setWalletBalance(customer.getWalletBalance());
				return "Customer update";
			}
		}
		return null;
	}
	@Override
	public Object findById(int Id) {
		for(Customer product:collection) {
			if(product.getCustId()==Id) {
				return product;
			} 
		}
		return null;
	}
	@Override
	public String deleteById(int Id) {
		for(Customer product:collection) {
			if(product.getCustId()==Id) {
				collection.remove(product);
				return "Product Deleted";
			}
		}
		return null;
	}
	
	
}
