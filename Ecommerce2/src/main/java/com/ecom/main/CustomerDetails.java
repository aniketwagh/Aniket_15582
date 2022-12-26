package com.ecom.main;

import java.util.Set;

import com.ecom.dao.CustomerCollection;
import com.ecom.model.Customer;

public class CustomerDetails {

	public static void main(String[] args) {
		CustomerCollection cc = CustomerCollection.getCollection();
		Set<Customer> c =cc.getList();
		c.add(new Customer("ANIKET WAGHMARE","waghmareaniket7@gmail.com",34455, 7030977));
		c.add(new Customer("Akash WAGHMARE","waghmareakash7@gmail.com",34455, 7030977));
		for(Customer c1: c) {
			System.out.println(c1);
		}
		System.out.println(cc.updatebyId(new Customer("Aniket","asc@gmail.com",456,6789054), 2));
	}
}
