package com.training.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.training.customer.model.Customer;
import com.training.customer.model.OrderItem;
import com.training.customer.model.Product;
import com.training.util.HibernateUtil;

public class OrderItemDao implements IDao<OrderItem> {
	private Session session;
	private Transaction transaction;
	private Query query;

	public OrderItemDao() {
		super();

	}

	@Override
	public boolean createNew(OrderItem orderitem) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(orderitem)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<OrderItem> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from OrderItem");
		final List<OrderItem> orderList=query.list();
		transaction.commit();
		return orderList;
	}

	@Override
	public OrderItem findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from OrderIteam o where o.orderItemId="+id);
		final OrderItem orderitem=(OrderItem) query.getSingleResult();
		transaction.commit();
		return orderitem;
	}

	@Override
	public boolean findOneandDelete(int id) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from OrderIteam o where o.orderItemId=:id");
		query.setParameter("id",id);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, OrderItem orderitem) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update OrderIteam o set o.quantity=:quantity where orderItemId=:orderItemId");
		query.setParameter("orderItemId", id);
		query.setParameter("quantity", orderitem.getQuantity());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}

	
}
