package com.training.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.training.customer.model.Customer;
import com.training.util.HibernateUtil;

public class CustomerDao implements IDao<Customer> {
	private Session session;
	private Transaction transaction;
	private Query query;

	public CustomerDao() {
		super();

	}

	public boolean createNew(Customer customer) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(customer)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<Customer> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Customer");
		final List<Customer> customerList=query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public Customer findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Customer c where c.custId="+id);
		final Customer customer=(Customer) query.getSingleResult();
		transaction.commit();
		return customer;
	}

	@Override
	public boolean findOneandDelete(int custId) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from Customer c where c.custID=:id");
		query.setParameter("id",custId);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
		System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, Customer customer) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update Customer c set c.custName=:custName where custId=:custId");
		query.setParameter("custId",id);
		query.setParameter("custName",customer.getCustName());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}
}
