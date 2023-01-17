package com.ecom.collection;

import java.sql.SQLException;
import java.util.List;

import com.ecom.dao.OrderDetailsDao;
import com.ecom.model.OrderDetails;

public class OrderDetailsCollection implements IOrderDetailsCollection<OrderDetails> {
	private static OrderDetailsCollection orderDetailscollection;
	private List<OrderDetails> orderDetailsList;
	private OrderDetailsDao orderDetailDao;
	
	

	public OrderDetailsCollection() {
		super();
		this.orderDetailDao = orderDetailDao.getOrderDetailsDao();
	}

	public static OrderDetailsCollection getOrderDetailsCollection() {
		if (orderDetailscollection == null) {
			synchronized (OrderDetailsCollection.class) {
				if (orderDetailscollection == null) {
					orderDetailscollection = new OrderDetailsCollection();
				}
			}
		}
		return orderDetailscollection;
	}
	
	@Override
	public List<OrderDetails> findAll() {
		
		orderDetailsList = orderDetailDao.findAll();
		return orderDetailsList;
	}

	@Override
	public OrderDetails findOne(int orderId) {
		
		OrderDetails orderDetails = orderDetailDao.findOne(orderId);
		return orderDetails;
	}

	@Override
	public boolean createNew(OrderDetails orderDetails) {
		
		return orderDetailDao.createNew(orderDetails);
	}

	@Override
	public boolean findOneAndDelete(int orderId) {
		
		return orderDetailDao.findOneAndDelete(orderId);
	}
}
