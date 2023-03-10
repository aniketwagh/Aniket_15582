package com.meeshoapp;

import java.util.Set;

import com.ecom.model.Customer;

public interface IMeeshoCollection<T> {

	abstract Set<T> getList();

	public abstract String createNewCustomer(Customer custName);
	
	public abstract String updatebyId(T entity, int Id);

	public abstract T findById(int Id);

	public abstract String deleteById(int Id);
}
