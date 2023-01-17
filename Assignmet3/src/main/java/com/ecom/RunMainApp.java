package com.ecom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ecom.controller.CartController;
import com.ecom.controller.CustomerController;
import com.ecom.controller.OrderDetailsController;
import com.ecom.controller.ProductController;
import com.ecom.model.Cart;
import com.ecom.model.Customer;
import com.ecom.model.OrderDetails;
import com.ecom.model.Product;

public class RunMainApp {

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);

		ProductController productController = ProductController.getProductController();
//		createProducts(productController);
		CustomerController customerController = CustomerController.getCustomerController();
//		createCustomer(customerController);
		CartController cartController = CartController.getCartItemController();

		OrderDetailsController orderDetailsController = OrderDetailsController.getOrderDetailsController();

		List<Cart> cartList = new ArrayList<>();
		Customer customer = new Customer();
//		System.out.println("Please Login with your credentials");
//		int customerLoginId = sc.nextInt();
//		Customer customer = customerController.findOne(customerLoginId);
		System.out.println("The Available Products is:");
		productController.findAll().forEach(System.out::println);
		OrderDetails orderDetails = new OrderDetails(new Date(), customer);
		while (true) {
			System.out.println("Select the productId to add to cart");
			final int productId = sc.nextInt();
			Product product = productController.findOne(productId);
			System.out.println("Select the product quantity");
			final int quantity = sc.nextInt();
			Cart cart = new Cart(quantity, product.getUnitPrice() * quantity, product, orderDetails);
			cartList.add(cart);
			System.out.println("Do you want to add some more products to cart");
			System.out.println("If YES--> Type as Yes");
			System.out.println("If NO--> Type as No");
			String option = sc.next();
			if (option.equalsIgnoreCase("No")) {
				break;
			}
		}
		System.out.println("\nYou have selected the following products");
		System.out.println("***************************************************************");
		cartList.forEach(System.out::println);
		System.out.println("***************************************************************\n");
		orderDetails.setCartList(cartList);
		orderDetailsController.createNew(orderDetails);
		for (Cart cart : cartList) {
			cartController.createNew(cart);
		}
		System.out.println("\n**************************************************************************************");
		System.out.println("Your cart items details:");
		System.out
		.println("****************************************************************************************\n");
		double totalOrderPrice = 0.0;
		for (Cart cart : cartList) {
			totalOrderPrice = totalOrderPrice + cart.getTotalItemPrice();
		}
		System.out.println("Your Order details are here.");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Your Total Order Price is: " + totalOrderPrice);
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println(orderDetails);
	}
}
