package com.santamweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santamweb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
  
}
