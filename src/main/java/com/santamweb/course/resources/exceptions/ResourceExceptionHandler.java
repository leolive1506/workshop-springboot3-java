package com.santamweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.santamweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

// intercepta exceções que acontecerem para que esse obj possa executar um possível tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

  // especificar qual exceção vai interceptar
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    String error = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(
      Instant.now(),
      status.value(),
      error,
      e.getMessage(),
      request.getRequestURI()
    );

    return ResponseEntity.status(status).body(err);
  }
}