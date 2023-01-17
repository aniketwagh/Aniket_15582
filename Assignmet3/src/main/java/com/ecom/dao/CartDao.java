package com.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecom.model.Cart;
import com.ecom.model.Product;
import com.ecom.util.HibernateUtil;

import com.ecom.model.Cart;

public class CartDao implements IDao<Cart> {

	private Session session;
	private Transaction transaction;
	private Query query;

	public double itemTotalPrice;

	private static CartDao cartDao;

	public static CartDao getCartDao() {
		if (cartDao == null) {
			synchronized (CartDao.class) {
				if (cartDao == null) {
					cartDao = new CartDao();
				}
			}
		}
		return cartDao;
	}

	@Override
	public List<Cart> findAll() {

		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Cart");
		final List<Cart> cartList = query.list();
		transaction.commit();
		return cartList;
	}

	@Override
	public Cart findOne(int cartId) {

		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Cart c where c.cartId=" + cartId);
		final Cart cart = (Cart) query.getSingleResult();
		transaction.commit();
		return cart;
	}

	@Override
	public boolean createNew(Cart cart) {

		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(cart) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	@Override
	public boolean findOneAndDelete(int cartId) {

		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Cart c where c.cartId=:cartId");
		query.setParameter("cartId", cartId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean findOneAndUpdate(int cartId, Cart cart) {

		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Cart c set c.quantity=:quantity where c.cartId=:cartId");
		int quantity = cart.getQuantity();
		query.setParameter("quantity", quantity);
		query.setParameter("cartId", cartId);
		final int statusUpdate1 = query.executeUpdate();

		transaction.commit();
		if (statusUpdate1 > 0) {
			query = session.createQuery("Update Cart c set c.itemTotalPrice=:itemTotalPrice where c.cartId=:cartId");
			Product product = new Product();
			itemTotalPrice = quantity * product.getUnitPrice();
			query.setParameter("itemTotalPrice", itemTotalPrice);
			query.setParameter("cartId", cartId);
			final int statusUpdate2 = query.executeUpdate();
			if (statusUpdate2 > 0) {
				result = true;
			}

		}
		return result;
	}

}
