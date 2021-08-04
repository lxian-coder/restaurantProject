package com.darcy.restaurantproject.auth;

import java.util.Optional;

/**
 * Darcy Xian  4/8/21  10:58 pm      restaurantProject
 */
public interface ApplicationUserDao {
    Optional<ApplicationUserService> fetchUserByUsername(String name);

}
