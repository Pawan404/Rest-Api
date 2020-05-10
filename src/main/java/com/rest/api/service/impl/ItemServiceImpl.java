package com.rest.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Item;
import com.rest.api.entity.Order;
import com.rest.api.repository.ItemRepository;
import com.rest.api.repository.OrderRepository;
import com.rest.api.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Item> findAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	/*
	 * @Override public Item updateItem(Item item) {
	 * 
	 * return itemRepository.save(item); }
	 */

	@Override
	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Item updateItem(Item item) {
		Item itm = itemRepository.findById(item.getItemId()).get();
		itm.setItemName(item.getItemName());
		itm.setItemPrice(item.getItemPrice());
		itm.setItemDescription(item.getItemDescription());
		itm.setOrder(item.getOrder());
		return itemRepository.save(itm);
	}

}
