package com.Ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.Ecom.model.Order;

public class OrderController implements IController<Order> {
	
	private static OrderController ordercontroller;
	private OrderCollection ordercollection;
	public OrderController() {
		super();
		this.ordercollection = OrderCollection.getOrderCollection();
	}
	
	public static OrderController getOrderController() {
		if(ordercontroller == null) {
			synchronized (OrderController.class) {
				if(ordercontroller == null) {
					ordercontroller = new OrderController();
				}
			}
		}
		return ordercontroller;
	}

	public List<Order> findAll() throws SQLException {
		return ordercollection.findAll();
	}

	public Order findOne(int id) throws SQLException {
		return ordercollection.findOne(id);
	}

	public boolean createNew(Order t) throws SQLException {
		return ordercollection.createNew(t);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return ordercollection.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Order t) throws SQLException {
		return ordercollection.findOneAndUpdate(id, t);
	}
	
	

}
