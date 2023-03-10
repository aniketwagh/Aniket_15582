package com.Ecom.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Ecom.model.Order;

public class OrderDao implements IDao<Order>{

	private DbConnection db;
	private static OrderDao orderdao;
	public OrderDao() {
		super();
	}
	public OrderDao(DbConnection db) {
		super();
		this.db = db;
	}

	public static OrderDao getDao() {
		if(orderdao==null) {
			synchronized (OrderDao.class) {
				if(orderdao==null){
					orderdao=new OrderDao(DbConnection.getDb());
				}
			}
		}
		return orderdao;
	}
	public List<Order> findAll() throws SQLException {
		final List<Order> list = new ArrayList<Order>();
		Connection connect = db.getConnection();
		Statement statement = connect.createStatement();
		final String sql = "select orderid,ordername,totalprice from order";
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Order(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
		}
		return list;
	}
	public Order findOne(int id) throws SQLException {
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select orderid , ordername, totalprice from order where orderid="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Order order=new Order(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
			return order;
		}
		return null;
	}
	public boolean createNew(Order t) throws SQLException {
		Connection connect=db.getConnection();		
		final String sql="insert into product values(?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, t.getOrderid());
		pStatement.setString(2, t.getOrdername());
		pStatement.setInt(3, t.getTotalprice());
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="delete from order where orderid=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
	public boolean findOneAndUpdate(int id, Order t) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update order set ordername=? where orderid=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, t.getOrderid());
		pStatement.setString(2, t.getOrdername());
		pStatement.setInt(3, t.getTotalprice());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
}