package com.ecom.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dto.OrderItemData;
import com.ecom.model.OrderItem;

@Service
public class OrderItemService implements IService<OrderItemData> {

	@Autowired
	private IOrderItemRepository iorderItemRepository;

	private OrderItem getOrderItem(OrderItemData orderItemData) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemId(orderItemData.getOrderItemId());
		orderItem.setQuntity(orderItemData.getQuntity());
		orderItem.setProduct(orderItemData.getProduct());
		return orderItem;
	}

	private OrderItemData getOrderItemData(OrderItem orderItem) {
		OrderItemData orderItemData = new OrderItemData();
		orderItemData.setOrderItemId(orderItem.getOrderItemId());
		orderItemData.setQuntity(orderItem.getQuntity());
		orderItemData.setProduct(orderItem.getProduct());
		return orderItemData;
	}

	@Override
	public List<OrderItemData> findAll() {
		List<OrderItemData> orderItemDataList = new ArrayList<>();
		List<OrderItem> orderItems = this.iorderItemRepository.findAll();
		orderItems.forEach(orderItem -> {
			orderItemDataList.add(getOrderItemData(orderItem));
		});
		return orderItemDataList;
	}

	@Override
	public OrderItemData createNew(OrderItemData orderItemData) {
		OrderItem orderItem = getOrderItem(orderItemData);
		iorderItemRepository.save(orderItem);
		return getOrderItemData(orderItem);
	}

	@Override
	public OrderItemData findById(Long id) {
		OrderItem orderItem = iorderItemRepository.findById(id).get();
		if (orderItem != null) {
			return getOrderItemData(orderItem);
		}
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		OrderItem orderItem = iorderItemRepository.findById(id).get();
		if (orderItem != null) {
			iorderItemRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateById(Long id, OrderItemData orderItemData) {
		OrderItem orderItem = iorderItemRepository.findById(id).get();
		if (orderItem != null) {
			orderItem.setOrderItemId(orderItemData.getOrderItemId());
			orderItem.setQuntity(orderItemData.getQuntity());
			orderItem.setProduct(orderItemData.getProduct());
			return true;
		}
		return false;
	}
}
