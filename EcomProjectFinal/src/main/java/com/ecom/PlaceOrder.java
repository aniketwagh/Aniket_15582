package com.ecom;

import java.util.List;

import com.ecom.dao.DbConnection;
import com.ecom.dao.OrderDao;
import com.ecom.model.Order;


public class PlaceOrder {

	public static void main(String[] args) {
		try {
			final DbConnection db=DbConnection.getDb();
			final OrderDao dao=new OrderDao(db);
			final List<Order> list=dao.findAll();
			for(Order o: list) {
				System.out.println(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
