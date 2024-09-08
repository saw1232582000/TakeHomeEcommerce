package com.Ecommerce.Ecommerce.application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
