package com.ecom.collection;

import java.sql.SQLException;
import java.util.List;

import com.ecom.dao.CartDao;
import com.ecom.model.Cart;

public class CartCollection implements ICollection<Cart> {

	private static CartCollection cartCollection;
	private List<Cart> cartList;
	private CartDao cartDao;
	
	
	
	public CartCollection() {
		super();
		this.cartDao = cartDao.getCartDao();
	}

	public static CartCollection getCartCollection() {
		if(cartCollection == null) {
			synchronized (CartCollection.class) {
				if(cartCollection==null) {
					cartCollection = new CartCollection();
				}
			}
		}
		return cartCollection;
	}
	
	@Override
	public List<Cart> findAll() {
		
		cartList = cartDao.findAll();
		return cartList;
	}

	@Override
	public Cart findOne(int cartId) {
		
		Cart cart = cartDao.findOne(cartId);
		return cart;
	}

	@Override
	public boolean createNew(Cart cart) {
		
		return cartDao.createNew(cart);
	}

	@Override
	public boolean findOneAndDelete(int cartId) {
		
		return cartDao.findOneAndDelete(cartId);
	}

	@Override
	public boolean findOneAndUpdate(int cartId, Cart cart) {
		
		return cartDao.findOneAndUpdate(cartId, cart);
	}

}
