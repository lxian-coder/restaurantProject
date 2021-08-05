package com.darcy.restaurantproject.repositories;

import com.darcy.restaurantproject.entities.Menu;
import com.darcy.restaurantproject.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Darcy Xian  4/8/21  11:51 am      restaurantProject
 */
@Repository

public interface UserRepository  extends JpaRepository<Menu, Long> {

   @Query("select u from User u join fetch u.authorities a where u.username=:username")
   User findByUsername(@Param("username") String username);

}
