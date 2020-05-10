package com.rest.api.controller;

import java.util.List;

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
public class ItemController {
static {
	System.out.println("Testing");
}
	@Autowired
	private ItemService itemService;

	@GetMapping("/get-items")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> items = null;
		try {
			items = itemService.findAllItems();
		} catch (Exception e) {
			throw new ItemNotFoundException();

		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

	@PostMapping("/item")
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		Item createdItem = null;
		try {
			if (item != null) {
				createdItem = itemService.createItem(item);
			}
		} catch (Exception e) {

			throw new ItemNotFoundException();
		}
		return new ResponseEntity<Item>(createdItem, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) {
		Item createdItem = null;
		try {
			if (item != null) {
				createdItem = itemService.updateItem(item);
			}
		} catch (Exception e) {
			throw new ItemNotFoundException();
		}
		return new ResponseEntity<Item>(createdItem, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long itemId) {
		try {
			if (itemId != null) {
				itemService.deleteItem(itemId);
			}
		} catch (Exception e) {
			throw new ItemNotFoundException();
		}
		return new ResponseEntity<>("Item with ID :" + itemId + " deleted successfully", HttpStatus.OK);

	}

	@PostMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {

		Order createdOrder = itemService.createOrder(order);

		return new ResponseEntity<Order>(createdOrder, HttpStatus.OK);

	}

	@GetMapping("/get-orders")
	public ResponseEntity<List<Order>> getAllOrders() {

		List<Order> orders = itemService.getAllOrders();
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

}
