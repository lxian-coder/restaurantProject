package com.darcy.restaurantproject.repositories;

import com.darcy.restaurantproject.RestaurantProjectApplication;
import com.darcy.restaurantproject.entities.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Darcy Xian  23/5/21  10:45 pm      restaurantProject
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestaurantProjectApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void shouldSaveEventSuccessfullyGivenEventObject(){
        Event event = new Event();
        event.setDescription("aaa");
       Event returnEvent = eventRepository.save(event);

        assertNotNull(event.getId());
        assertEquals("aaa",returnEvent.getDescription());
    }
    @Test
    public void shouldFindEventGivenID(){
        Event event = new Event();
        event.setId(1L);
        event.setDescription("a");
        eventRepository.save(event);

        Event returnedEvent = eventRepository.findById(1L).get();
        assertEquals("a",returnedEvent.getDescription());
    }
}
