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

import com.ecom.dto.OrderItemData;
import com.ecom.services.OrderItemService;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@GetMapping("/orderitems")
	public List<OrderItemData> findAll() {
		return orderItemService.findAll();
	}

	@PostMapping("/createneworder")
	public OrderItemData createNew(@RequestBody OrderItemData orderItemData) {
		return orderItemService.createNew(orderItemData);
	}

	@GetMapping("/orderitem/{id}")
	public OrderItemData findById(@PathVariable long id) {
		return orderItemService.findById(id);
	}

	@DeleteMapping("/orderitem/delete/{id}")
	public boolean deleteById(@PathVariable long id) {
		return orderItemService.deleteById(id);
	}

	@PutMapping("/orderitem/update/{id}")
	public boolean updateById(@PathVariable long id, OrderItemData orderItemData) {
		return orderItemService.updateById(id, orderItemData);
	}
}
