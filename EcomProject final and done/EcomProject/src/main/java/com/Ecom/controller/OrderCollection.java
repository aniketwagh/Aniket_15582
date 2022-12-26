package com.Ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.Ecom.Dao.OrderDao;
import com.Ecom.Dao.ProductDao;
import com.Ecom.model.Order;
import com.Ecom.model.ProductDetails;

public class OrderCollection implements ICollection<Order>{
	
	private static OrderCollection collection;
	private OrderDao dao;
	private List<Order> orderList;
	
	
	
	public OrderCollection() {
		super();
		this.dao = OrderDao.getDao();
	}



	public static OrderCollection getOrderCollection() {
		if(collection==null) {
			synchronized (OrderCollection.class) {
				if(collection==null) {
					collection=new OrderCollection();
				}
				
			}
		}
		return collection;
	}



	public List<Order> findAll() throws SQLException {
		orderList=dao.findAll();
		return orderList;
	}



	public Order findOne(int id) throws SQLException {
		Order order = dao.findOne(id);
		return order;
	}



	public boolean createNew(Order t) throws SQLException {
		return dao.createNew(t);
	}



	public boolean findOneAndDelete(int id) throws SQLException {
		return dao.findOneAndDelete(id);
	}



	public boolean findOneAndUpdate(int id, Order t) throws SQLException {
		return dao.findOneAndUpdate(id, t);
	}
	
	

}
