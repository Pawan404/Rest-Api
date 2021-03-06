package com.rest.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entity.Item;
import com.rest.api.entity.Order;
import com.rest.api.exception.ItemNotFoundException;
import com.rest.api.service.ItemService;

@RestController
public class OrderItemController {

	public static final Logger logger = LoggerFactory.getLogger(OrderItemController.class);

	@Autowired
	private ItemService itemService;

	@GetMapping("/get-items")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> items = null;
		items = itemService.findAllItems();
		if (items == null)
			throw new ItemNotFoundException("Item is not found");

		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

	@GetMapping("/get-item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		Item item = null;
		item = itemService.findById(id);
		if (item == null) {
			logger.info("");
			throw new ItemNotFoundException("Invalid Item id : " + id);
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);

	}

	@PostMapping("/item")
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		Item createdItem = itemService.createItem(item);
		return new ResponseEntity<Item>(createdItem, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) {
		Item createdItem = null;
		try {
			if (item != null) {
				createdItem = itemService.updateItem(item);
			}
		} catch (Exception e) {
			throw new ItemNotFoundException("Item is not available");
		}
		return new ResponseEntity<Item>(createdItem, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable Long itemId) {
		try {
			if (itemId != null) {
				itemService.deleteItem(itemId);
			}
		} catch (Exception e) {
			throw new ItemNotFoundException(" Item Id is not foune");
		}
		return new ResponseEntity<>("Item with ID :" + itemId + " deleted successfully", HttpStatus.OK);

	}

	@PostMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {

		Order createdOrder = itemService.createOrder(order);

		return new ResponseEntity<Order>(createdOrder, HttpStatus.CREATED);

	}

	@PutMapping("/order-update")
	public ResponseEntity<Order> updateItem(@RequestBody Order order) {
		Order updateOrder = null;
		try {
			if (order != null) {
				updateOrder = itemService.updateOrder(order);
			}
		} catch (Exception e) {
			return new ResponseEntity(
					new com.rest.api.exception.CustomErrorType(
							"Unable to upate. Order with id " + order.getOrderId() + " not found."),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Order>(updateOrder, HttpStatus.OK);

	}

	@GetMapping("/get-orders")
	public ResponseEntity<List<Order>> getAllOrders() {

		List<Order> orders = itemService.getAllOrders();
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

	@DeleteMapping("/order-delete/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
		try {
			if (orderId != null) {
				itemService.deleteOrder(orderId);
			}
		} catch (Exception e) {
			throw new ItemNotFoundException("");
		}
		return new ResponseEntity<>("Order with ID :" + orderId + " deleted successfully", HttpStatus.OK);

	}
	

	@PostMapping("/bulk-order")
	public ResponseEntity<Order> bulkOrdering(@RequestBody Order orders) {
		Order bulkOrdering = null;
		try {
			if (orders != null) {

				bulkOrdering = itemService.bulkOrdering(orders);
			}

		} catch (Exception e) {
			logger.info("Orders should not empty");
		}
		return new ResponseEntity<Order>(bulkOrdering, HttpStatus.CREATED);
	}

}
