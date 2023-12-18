package com.santamweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santamweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
  
}
