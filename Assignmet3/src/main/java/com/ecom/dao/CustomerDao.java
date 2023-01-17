package com.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecom.model.Customer;
import com.ecom.util.HibernateUtil;

public class CustomerDao implements IDao<Customer>{

	private Session session;
	private Transaction transaction;
	private Query query;

	private static CustomerDao customerDao;

	public static CustomerDao getCustomerDao() {
		if (customerDao == null) {
			synchronized (CustomerDao.class) {
				if (customerDao == null) {
					customerDao = new CustomerDao();
				}
			}
		}
		return customerDao;
	}
	
	@Override
	public List<Customer> findAll() {

		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Customer");
		final List<Customer> customerList = query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public Customer findOne(int customerId) {

		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Customer c where c.customerId=" + customerId);// select * from book
		final Customer customer = (Customer) query.getSingleResult();
		transaction.commit();
		return customer;
	}

	@Override
	public boolean createNew(Customer customer) {

		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(customer) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	@Override
	public boolean findOneAndDelete(int customerId) {

		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Customer c where c.customerId=:customerId");
		query.setParameter("customerId", customerId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean findOneAndUpdate(int customerId, Customer customer) {

		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Customer c set c.customerName=:customerName where customerId=:customerId");
		query.setParameter("customerName", customer.getCustomerName());
		query.setParameter("customerId", customerId);
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}
}
