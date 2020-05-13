package com.rest.api.service;

import java.util.List;

import com.rest.api.entity.Item;
import com.rest.api.entity.Order;

public interface ItemService {

	List<Item> findAllItems();

	Item createItem(Item item);

	Order createOrder(Order order);

	Item updateItem(Item item);


	void deleteItem(Long itemId);

	List<Order> getAllOrders();

	Item findById(Long id);

	Order updateOrder(Order order);

	void deleteOrder(Long orderId);

	List<Order> bulkOrdering(List<Order> orders);

}
