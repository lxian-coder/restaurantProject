package com.darcy.restaurantproject.repositories;

import com.darcy.restaurantproject.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Darcy Xian  23/5/21  10:19 pm      restaurantProject
 */
@Repository
public interface EventRepsitory extends JpaRepository<Event,Long> {
}
