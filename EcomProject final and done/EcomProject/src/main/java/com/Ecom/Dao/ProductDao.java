package com.Ecom.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Ecom.model.ProductDetails;

public class ProductDao implements IDao<ProductDetails>{
	
	private DbConnection db;
	private static ProductDao productdao;
	public ProductDao() {
		super();
	}
	public ProductDao(DbConnection db) {
		super();
		this.db = db;
	}

	public static ProductDao getDao() {
		if(productdao==null) {
			synchronized (ProductDao.class) {
				if(productdao==null){
					productdao=new ProductDao(DbConnection.getDb());
				}
			}
		}
		return productdao;
	}
	public List<ProductDetails> findAll() throws SQLException {
		final List<ProductDetails> list = new ArrayList<ProductDetails>();
		Connection connect = db.getConnection();
		Statement statement = connect.createStatement();
		final String sql = "select productid , productname, productdescription, quantity from product";
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new ProductDetails(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));
		}
		return list;
	}
	public ProductDetails findOne(int id) throws SQLException {
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select productid , productname, productdescription, quantity from product where productid="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final ProductDetails productdetails=new ProductDetails(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
			return productdetails;
		}
		return null;
	}
	public boolean createNew(ProductDetails t) throws SQLException {
		Connection connect=db.getConnection();		
		final String sql="insert into product values(?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, t.getProductid());
		pStatement.setString(2, t.getProductname());
		pStatement.setString(3, t.getProductdescription());
		pStatement.setInt(1, t.getQuantity());
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="delete from product where productid=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
	public boolean findOneAndUpdate(int id, ProductDetails t) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update product set productname=? where productid=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, t.getProductid());
		pStatement.setString(2, t.getProductname());
		pStatement.setString(3, t.getProductdescription());
		pStatement.setInt(4, t.getQuantity());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
}
