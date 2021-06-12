package com.darcy.restaurantproject.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  9/5/21  5:06 pm      restaurantProject
 */
@Getter
@Setter
@Component
public class MenuGetDTO {

    private Long id;

    private String description;

    private String price;

    private String price2;

    private String category;

    private boolean special;


}


