package com.Ecom.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Ecom.model.Customer;

public class CustomerDao implements IDao<Customer>{
	
	private DbConnection db;
	private static CustomerDao customerdao;
	public CustomerDao() {
		super();
		
	}
	public CustomerDao(DbConnection db) {
		super();
		this.db = db;
	}
	
	public static CustomerDao getDao() {
		if(customerdao==null) {
			synchronized (ProductDao.class) {
				if(customerdao==null){
					customerdao=new CustomerDao(DbConnection.getDb());
				}
				
			}
		}
		return customerdao;
	

}
	public List<Customer> findAll() throws SQLException {
		final List<Customer> list = new ArrayList<Customer>();
		Connection connect = db.getConnection();
		Statement statement = connect.createStatement();
		final String sql = "select custid, custname, custemail, custphone from customer";
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));
		}
		return list;
	}
	public Customer findOne(int id) throws SQLException {
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select custid , custname, custemail, custphone from customer where custid="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Customer customer=new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
			return customer;
		}
		return null;
	}
	public boolean createNew(Customer t) throws SQLException {
		Connection connect=db.getConnection();		
		final String sql="insert into customer (custid, custname, custemail, custphone) values(?,?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, t.getCustid());
		pStatement.setString(2, t.getCustname());
		pStatement.setString(3, t.getCustemail());
		pStatement.setInt(1, t.getCustphone());
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="delete from customer where custid=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
	public boolean findOneAndUpdate(int id, Customer t) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update customer set custname=? where cust=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, t.getCustid());
		pStatement.setString(2, t.getCustname());
		pStatement.setString(3, t.getCustemail());
		pStatement.setInt(4, t.getCustphone());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
}