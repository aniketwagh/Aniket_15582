package com.ecom.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dto.OrdersData;
import com.ecom.model.Orders;

@Service
public class OrdersService implements IService<OrdersData> {

	@Autowired
	private IOrdersRepository iordersRepository;

	private Orders getOrders(OrdersData ordersData) {
		Orders orders = new Orders();
		orders.setOrderId(ordersData.getOrderId());
		orders.setOrderdate(ordersData.getOrderdate());
		orders.setOrderstatus(ordersData.getOrderstatus());
		orders.setCustomer(ordersData.getCustomer());
		orders.setOrderItems(ordersData.getOrderItems());
		return orders;
	}

	private OrdersData getOrdersData(Orders orders) {
		OrdersData ordersData = new OrdersData();
		ordersData.setOrderId(orders.getOrderId());
		ordersData.setOrderdate(orders.getOrderdate());
		ordersData.setOrderstatus(orders.getOrderstatus());
		ordersData.setCustomer(orders.getCustomer());
		ordersData.setOrderItems(orders.getOrderItems());
		return ordersData;
	}

	@Override
	public List<OrdersData> findAll() {
		List<OrdersData> ordersDataList = new ArrayList<>();
		List<Orders> orders = this.iordersRepository.findAll();
		orders.forEach(ordersItem -> {
			ordersDataList.add(getOrdersData(ordersItem));
		});
		return ordersDataList;
	}

	@Override
	public OrdersData createNew(OrdersData ordersData) {
		Orders orders = getOrders(ordersData);
		iordersRepository.save(orders);
		return getOrdersData(orders);
	}

	@Override
	public OrdersData findById(Long id) {
		Orders orders = iordersRepository.findById(id).get();
		if (orders != null) {
			return getOrdersData(orders);
		}
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		Orders orders = iordersRepository.findById(id).get();
		if (orders != null) {
			iordersRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateById(Long id, OrdersData ordersData) {
		Orders orders = iordersRepository.findById(id).get();
		if (orders != null) {
			orders.setOrderId(ordersData.getOrderId());
			orders.setOrderdate(ordersData.getOrderdate());
			orders.setOrderstatus(ordersData.getOrderstatus());
			orders.setCustomer(ordersData.getCustomer());
			orders.setOrderItems(ordersData.getOrderItems());
			return true;
		}
		return false;
	}
}
