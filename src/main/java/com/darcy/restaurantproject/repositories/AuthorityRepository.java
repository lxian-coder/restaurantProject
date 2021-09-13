package com.darcy.restaurantproject.repositories;

import com.darcy.restaurantproject.entities.Authority;
import com.darcy.restaurantproject.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Darcy Xian  4/8/21  11:53 am      restaurantProject
 */
@Repository
public interface AuthorityRepository  extends JpaRepository<Authority, Long> {

   Optional<Authority> findByPermission(String permission);
}
