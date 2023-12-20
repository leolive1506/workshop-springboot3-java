package com.santamweb.course.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.santamweb.course.entities.User;
import com.santamweb.course.repositories.UserRepository;
import com.santamweb.course.services.exceptions.DatabaseException;
import com.santamweb.course.services.exceptions.ResourceNotFoundException;

// registra como componente do spring
@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User obj) {
    return repository.save(obj);
  }

  public void delete(Long id) {
    try {
      repository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
  }

  public User update(Long id, User obj) {
    // deixa obj monitorado pelo JPA mas não vai no db ainda
    // melhor que usar findById
    // so prepara obj pra depois mexer com banco de dados
    User entity = repository.getReferenceById(id);
    updateData(entity, obj);
  
    return repository.save(entity);
  }

  public void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}
