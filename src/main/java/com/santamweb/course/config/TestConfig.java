package com.santamweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.santamweb.course.entities.Order;
import com.santamweb.course.entities.User;
import com.santamweb.course.entities.enums.OrderStatus;
import com.santamweb.course.repositories.OrderRepository;
import com.santamweb.course.repositories.UserRepository;

@Configuration
// profile é o mesmo do arquivo properties
@Profile("test")
public class TestConfig implements CommandLineRunner {
  // injeção depencia
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  // seeder ao iniciar aplicação
  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "34 12431243", "asfdasdf");
    User u2 = new User(null, "Alex", "alex@gmail.com", "34 12431243", "asfdasdf");

    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
    Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
    Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }
}
