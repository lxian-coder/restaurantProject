package com.darcy.restaurantproject.repositories;

import com.darcy.restaurantproject.RestaurantProjectApplication;
import com.darcy.restaurantproject.entities.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Darcy Xian  23/5/21  10:45 pm      restaurantProject
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestaurantProjectApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EventRepositoryTest {

    @Autowired
    private EventRepsitory eventRepsitory;

    @Test
    public void shouldSaveEventSuccessfullyGivenEventObject(){
        Event event = new Event();


    }
}
