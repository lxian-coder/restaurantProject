package com.darcy.restaurantproject.controllers;

import com.darcy.restaurantproject.dtos.EventGetDTO;
import com.darcy.restaurantproject.dtos.EventPostDTO;
import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.entities.Event;
import com.darcy.restaurantproject.mappers.EventMapper;
import com.darcy.restaurantproject.repositories.EventRepository;
import com.darcy.restaurantproject.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Darcy Xian  23/5/21  1:04 pm      restaurantProject
 */
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
//    private final EventRepository eventRepository;
//    private final EventMapper eventMapper;

    @PatchMapping("/{eventId}")
    public ResponseEntity<EventGetDTO> updateMenuItem(@PathVariable Long eventId, @RequestBody EventPostDTO eventPostDTO) {
        return ResponseEntity.ok(eventService.updateEvent(eventId, eventPostDTO));
    }
//    @PostMapping
//    public ResponseEntity<Event> updateMenuItem(@RequestBody EventPostDTO eventPostDTO) {
//        return ResponseEntity.ok(eventRepository.save(eventMapper.toEntity(eventPostDTO)));
//    }
}
