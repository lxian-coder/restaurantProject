package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.EventGetDTO;
import com.darcy.restaurantproject.dtos.EventPostDTO;
import com.darcy.restaurantproject.entities.Event;
import com.darcy.restaurantproject.exceptions.ResourceNotFoundException;
import com.darcy.restaurantproject.mappers.EventMapper;
import com.darcy.restaurantproject.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Darcy Xian  23/5/21  10:21 pm      restaurantProject
 */
@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventGetDTO updateEvent(Long id, EventPostDTO eventPostDTO){
     return eventRepository.findById(id).map(event->{

         if(eventPostDTO.getDescription() !=null){
             event.setDescription(eventPostDTO.getDescription());
         }
         if(eventPostDTO.getTitle() != null){
             event.setTitle(eventPostDTO.getTitle());
         }
         Event eventReturn = eventRepository.save(event);
         return eventMapper.fromEntity(eventReturn);
     }).orElseThrow(()->{
         throw new ResourceNotFoundException("Event not found");});
    }

    public EventGetDTO findByID(Long id){
        Event event = eventRepository.findById(id).get();
        return  eventMapper.fromEntity(event);
    }
}
