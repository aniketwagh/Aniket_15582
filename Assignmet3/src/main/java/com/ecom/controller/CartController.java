package com.ecom.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecom.collection.CartCollection;
import com.ecom.model.Cart;

public class CartController  implements IController<Cart>{
	private static CartController cartController;
	private CartCollection cartCollection;

	private CartController() {
		super();
		this.cartCollection = cartCollection.getCartCollection();
	}

	public static CartController getCartItemController() {
		if (cartController == null) {
			synchronized (CartController.class) {
				if (cartController == null) {
					cartController = new CartController();
				}
			}
		}
		return cartController;
	}
	
	@Override
	public List<Cart> findAll() {
		return cartCollection.findAll();
	}

	@Override
	public Cart findOne(int cartId) {
		
		return cartCollection.findOne(cartId);
	}

	@Override
	public boolean createNew(Cart cart) {
		
		return cartCollection.createNew(cart);
	}

	@Override
	public boolean findOneAndDelete(int cartId) {
		
		return cartCollection.findOneAndDelete(cartId);
	}

	@Override
	public boolean findOneAndUpdate(int cartId, Cart cart) {
		
		return cartCollection.findOneAndUpdate(cartId, cart);
	}
}
