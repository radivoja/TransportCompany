package com.qinshift.transportCompany.exception;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataException(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(" Referential integrity constraint violation:");
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handleResourceException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not existing endpoint");
    }

    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<String> handleSystemException(JpaSystemException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMostSpecificCause().toString());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMostSpecificCause().toString());
    }
}
