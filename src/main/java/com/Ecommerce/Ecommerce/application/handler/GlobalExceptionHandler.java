package com.Ecommerce.Ecommerce.application.handler;

import com.Ecommerce.Ecommerce.application.exception.ResourceNotFoundException;
import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CoreApiResponse<?>> handleException(ResourceNotFoundException exception){
        CoreApiResponse<?> response = CoreApiResponse.error(exception.getMessage(),HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
