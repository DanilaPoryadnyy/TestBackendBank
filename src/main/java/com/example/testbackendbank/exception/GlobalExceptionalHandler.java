package com.example.testbackendbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(UserInstanceNotFound.class)
    public ResponseEntity<?> handleNotFound(UserInstanceNotFound userNotFound) {
        Map<String, Object> map = new HashMap<>();
        map.put("Message :- ", userNotFound.getMessage());
        map.put("Status :- ", HttpStatus.NOT_FOUND);
        map.put("Code :-", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleAnyException(RuntimeException runtimeException) {
        Map<String, Object> map = new HashMap<>();
        map.put("Message :- ", runtimeException.getMessage());
        map.put("Status :- ", HttpStatus.INTERNAL_SERVER_ERROR);
        map.put("Code :- ", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
