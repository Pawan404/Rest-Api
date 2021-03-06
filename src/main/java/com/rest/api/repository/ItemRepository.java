package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
