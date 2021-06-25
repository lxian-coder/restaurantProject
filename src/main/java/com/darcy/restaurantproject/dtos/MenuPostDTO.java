package com.darcy.restaurantproject.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  9/5/21  5:15 pm      restaurantProject
 */
@Getter
@Setter
@Component
public class MenuPostDTO {

    private String description;

    private String price;

    private String price2;

    private String category;


}
