package com.Ecom;

import java.sql.SQLException;
import java.util.List;


import com.Ecom.controller.OrderController;

import com.Ecom.model.Order;

public class Ordercall {

	public static void main(String[] args) {
		try {
			final OrderController orderController = OrderController.getOrderController();
			System.out.println("CURD Opration");
			int choice =1;
			System.out.println("1. Display all Order");
			mainOptions(orderController,choice);

			System.out.println("2. Order Details");
			choice=2;
			mainOptions(orderController,choice);

			System.out.println("3. Delete Order");
			choice=3;
			mainOptions(orderController,choice);

			System.out.println("4. update Order");
			choice=4;
			mainOptions(orderController,choice);

			System.out.println("5. Create New Order");
			choice=5;
			mainOptions(orderController,choice);

			choice = 1;
			System.out.println("Display all Order");
			mainOptions(orderController,choice);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void mainOptions(final OrderController orderController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
			List<Order> list = orderController.findAll();
			for(Order o:list) {
				System.out.println(o);
			}
			break;
		case 2: 
			final Order order=orderController.findOne(1);
			System.out.println(order);
			break;
		case 3: 
			if(orderController.findOneAndDelete(2)) {
				System.out.println("Customer Deleted");
			}
			break;
		case 4: 
			final Order updatorder=orderController.findOne(6);
			updatorder.setOrdername("realme");
			if(orderController.findOneAndUpdate(2,updatorder)) {
				System.out.println("Customer update" );
			}
			break;	
		case 5: 
			final Order newOrder=new Order();
			if(orderController.createNew(newOrder)) {
				System.out.println(newOrder+ " Created in DB");
			}
			break;
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}

	}

