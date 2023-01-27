package com.ecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.OrdersData;
import com.ecom.services.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@GetMapping("/ordersall")
	public List<OrdersData> findAll() {
		return ordersService.findAll();
	}

	@PostMapping("/createneworders")
	public OrdersData createNew(@RequestBody OrdersData ordersData) {
		return ordersService.createNew(ordersData);
	}

	@GetMapping("/orders/{id}")
	public OrdersData findById(@PathVariable long id) {
		return ordersService.findById(id);
	}

	@DeleteMapping("/orders/delete/{id}")
	public boolean deleteById(@PathVariable long id) {
		return ordersService.deleteById(id);
	}

	@PutMapping("/orders/update/{id}")
	public boolean updateById(@PathVariable long id, OrdersData ordersData) {
		return ordersService.updateById(id, ordersData);
	}
}
