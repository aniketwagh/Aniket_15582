package com.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecom.model.OrderDetails;
import com.ecom.util.HibernateUtil;

public class OrderDetailsDao implements IOrderDetailsDao<OrderDetails>{
	private Session session;
	private Transaction transaction;
	private Query query;

	private static OrderDetailsDao orderDetailsDao;

	public static OrderDetailsDao getOrderDetailsDao() {
		if (orderDetailsDao == null) {
			synchronized (OrderDetailsDao.class) {
				if (orderDetailsDao == null) {
					orderDetailsDao = new OrderDetailsDao();
				}
			}
		}
		return orderDetailsDao;
	}

	@Override
	public List<OrderDetails> findAll() {

		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from OrderDetails");
		final List<OrderDetails> orderDetailsList = query.list();
		transaction.commit();
		return orderDetailsList;
	}

	@Override
	public OrderDetails findOne(int orderId) {

		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from OrderDetails o where o.orderId=" + orderId);
		final OrderDetails orderDetails = (OrderDetails) query.getSingleResult();
		transaction.commit();
		return orderDetails;
	}

	@Override
	public boolean createNew(OrderDetails orderDetails) {

		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(orderDetails) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	@Override
	public boolean findOneAndDelete(int orderId) {

		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from OrderDetails o where o.orderId=:orderId");
		query.setParameter("orderId", orderId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}
}
