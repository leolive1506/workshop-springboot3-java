package com.santamweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santamweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
