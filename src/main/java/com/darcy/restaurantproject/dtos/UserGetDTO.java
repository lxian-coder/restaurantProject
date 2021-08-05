package com.darcy.restaurantproject.dtos;

import com.darcy.restaurantproject.entities.Authority;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Darcy Xian  5/8/21  11:14 am      restaurantProject
 */
@Getter
@Setter
@Component
public class UserGetDTO {
    private Long id;
    private String username;
    private String passwordHint;
    private Set<Authority> authorities;
}