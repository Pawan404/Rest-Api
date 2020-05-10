package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
