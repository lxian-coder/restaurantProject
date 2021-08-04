package com.darcy.restaurantproject.repositories;

import com.darcy.restaurantproject.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Darcy Xian  4/8/21  11:53 am      restaurantProject
 */
public interface AuthorityRepository  extends JpaRepository<Menu, Long> {
}
