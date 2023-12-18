package com.santamweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santamweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
