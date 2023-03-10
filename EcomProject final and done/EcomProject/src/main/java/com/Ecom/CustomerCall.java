package com.Ecom;

import java.sql.SQLException;
import java.util.List;

import com.Ecom.controller.CustomerController;
import com.Ecom.controller.ProductController;
import com.Ecom.model.Customer;
import com.Ecom.model.ProductDetails;

public class CustomerCall {

	public static void main(String[] args) {
		try {
			final CustomerController customerController = CustomerController.getCustomerController();
			System.out.println("CURD Opration");
			int choice =1;
			System.out.println("1. Display all Customers");
			mainOptions(customerController,choice);

			System.out.println("2. Customer Details");
			choice=2;
			mainOptions(customerController,choice);

			System.out.println("3. Delete Customer");
			choice=3;
			mainOptions(customerController,choice);

			System.out.println("4. update Customer");
			choice=4;
			mainOptions(customerController,choice);

			System.out.println("5. Create New Customer");
			choice=5;
			mainOptions(customerController,choice);

			choice = 1;
			System.out.println("Display all Customer");
			mainOptions(customerController,choice);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void mainOptions(final CustomerController customerController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
			List<Customer> list=customerController.findAll();
			for(Customer c:list) {
				System.out.println(c);
			}
			break;
		case 2: 
			final Customer customer=customerController.findOne(1);
			System.out.println(customer);
			break;
		case 3: 
			if(customerController.findOneAndDelete(2)) {
				System.out.println("Customer Deleted");
			}
			break;
		case 4: 
			final Customer updatproduct=customerController.findOne(6);
			updatproduct.setCustname("Swaraj");
			if(customerController.findOneAndUpdate(2,updatproduct)) {
				System.out.println("Customer update" );
			}
			break;	
		case 5: 
			final Customer newCustomer=new Customer(4,"Akash","ak@gmail.com",67584989);
			if(customerController.createNew(newCustomer)) {
				System.out.println(newCustomer+ " Created in DB");
			}
			break;
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}
}

