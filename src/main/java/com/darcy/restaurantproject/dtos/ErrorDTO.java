package com.darcy.restaurantproject.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Darcy Xian  9/5/21  11:22 pm      restaurantProject
 */
@Getter
@Setter
@RequiredArgsConstructor
public class ErrorDTO {
    private final int errorCode;
    private final String message;
}
