package com.darcy.restaurantproject.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  23/5/21  1:02 pm      restaurantProject
 */
@Setter
@Getter
@Component
public class EventPostDTO {
    private Byte[] image;
    private String description;
}
