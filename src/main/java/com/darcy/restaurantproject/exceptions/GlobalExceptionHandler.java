package com.darcy.restaurantproject.exceptions;

import com.darcy.restaurantproject.dtos.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Darcy Xian  9/5/21  11:11 pm      restaurantProject
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleGameNotFoundException(ResourceNotFoundException ex) {
        log.warn("Resource not found:", ex);
        return ResponseEntity.ok(new ErrorDTO(404, ex.getMessage()));
    }

}
