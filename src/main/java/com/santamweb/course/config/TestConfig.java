package com.santamweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.santamweb.course.entities.User;
import com.santamweb.course.repositories.UserRepository;

@Configuration
// profile é o mesmo do arquivo properties
@Profile("test")
public class TestConfig implements CommandLineRunner {
  // injeção depencia
  @Autowired
  private UserRepository userRepository;

    // seeder ao iniciar aplicação
  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "34 12431243", "asfdasdf");
    User u2 = new User(null, "Alex", "alex@gmail.com", "34 12431243", "asfdasdf");

    userRepository.saveAll(Arrays.asList(u1, u2));
  }


}
