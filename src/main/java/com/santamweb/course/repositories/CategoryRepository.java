package com.santamweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santamweb.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  
}
