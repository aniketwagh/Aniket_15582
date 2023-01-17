package com.ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecom.collection.OrderDetailsCollection;
import com.ecom.model.OrderDetails;

public class OrderDetailsController implements IOrderDetailsController<OrderDetails>{
	private static OrderDetailsController orderDetailsController;
	private OrderDetailsCollection orderDetailsCollection;

	private OrderDetailsController() {
		super();
		this.orderDetailsCollection = orderDetailsCollection.getOrderDetailsCollection();
	}
	
	public static OrderDetailsController getOrderDetailsController() {
		if(orderDetailsController == null) {
			synchronized (OrderDetailsController.class) {
				if(orderDetailsController == null) {
					orderDetailsController = new OrderDetailsController();
				}
			}
		}
		return orderDetailsController;
	}
	
	@Override
	public List<OrderDetails> findAll() {
		
		return orderDetailsCollection.findAll();
	}

	@Override
	public OrderDetails findOne(int orderId) {
		
		return orderDetailsCollection.findOne(orderId);
	}

	@Override
	public boolean createNew(OrderDetails orderDetails) {
		
		return orderDetailsCollection.createNew(orderDetails);
	}

	@Override
	public boolean findOneAndDelete(int orderId) {
		
		return orderDetailsCollection.findOneAndDelete(orderId);
	}

}
