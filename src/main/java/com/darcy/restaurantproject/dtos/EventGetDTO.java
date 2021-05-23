package com.darcy.restaurantproject.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  23/5/21  12:59 pm      restaurantProject
 */
@Getter
@Setter
@Component
public class EventGetDTO {
    private  Long id;
    private Byte[] image;
    private String description;
}
