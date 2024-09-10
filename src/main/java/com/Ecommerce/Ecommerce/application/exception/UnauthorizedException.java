package com.Ecommerce.Ecommerce.application.exception;

public class UnauthorizedException  extends RuntimeException{
    public UnauthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
