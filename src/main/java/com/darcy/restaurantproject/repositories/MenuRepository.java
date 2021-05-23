package com.darcy.restaurantproject.repositories;

import com.darcy.restaurantproject.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Darcy Xian  9/5/21  5:18 pm      restaurantProject
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {


}
