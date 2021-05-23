package com.darcy.restaurantproject.exceptions;

/**
 * Darcy Xian  9/5/21  10:53 pm      restaurantProject
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {

    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
