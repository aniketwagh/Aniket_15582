package com.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecom.model.Product;
import com.ecom.util.HibernateUtil;

public class ProductDao implements IDao<Product>{
	private Session session;
	private Transaction transaction;
	private Query query;
	
	private  static ProductDao productDao;
	
	public static ProductDao getProductDao() {
		if (productDao == null) {
			synchronized (ProductDao.class) {
				if (productDao == null) {
					productDao = new ProductDao();
				}
			}
		}
		return productDao;
	}
	
	@Override
	public List<Product> findAll() {
		
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Product");
		final List<Product> productList = query.list();
		transaction.commit();
		return productList;
	}

	@Override
	public Product findOne(int productId) {
		
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Product p where p.productId=" + productId);
		final Product product = (Product) query.getSingleResult();
		transaction.commit();
		return product;
	}

	@Override
	public boolean createNew(Product product) {
		
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(product) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	@Override
	public boolean findOneAndDelete(int productId) {
		
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Product p where p.productId=:productId");
		query.setParameter("productId", productId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean findOneAndUpdate(int productId, Product product) {
		
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Product p set p.productName=:productName where productId=:productId");
		query.setParameter("productName", product.getProudctName());
		query.setParameter("productId", productId);
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}
}
