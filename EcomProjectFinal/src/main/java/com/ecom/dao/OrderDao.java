package com.ecom.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecom.model.Order;


public class OrderDao implements IDao<Order> {
	
	private DbConnection db;

	public OrderDao() {
		super();
		
	}
	
	public OrderDao(DbConnection db)
	{
		super();
		this.db=db;
	}

	public List<Order> findAll() throws SQLException {
		final List<Order> list=new ArrayList<Order>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select orderid, ordername, price from order";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Order(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));			
		}
		return list;
	}

	public Order findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createNew(Order t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean findOneAndUpdate(int id, Order t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	

}
