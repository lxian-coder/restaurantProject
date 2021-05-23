package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.EventGetDTO;
import com.darcy.restaurantproject.dtos.EventPostDTO;
import com.darcy.restaurantproject.exceptions.ResourceNotFoundException;
import com.darcy.restaurantproject.mappers.EventMapper;
import com.darcy.restaurantproject.repositories.EventRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Darcy Xian  23/5/21  10:21 pm      restaurantProject
 */
@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepsitory eventRepsitory;
    private final EventMapper eventMapper;

    public EventGetDTO saveEvent(Long id, EventPostDTO eventPostDTO){
     return eventRepsitory.findById(id).map(event->{
         // image 已经在另一页修改完毕，在这里只是看一下description 要不要改；
         event.setDescription(eventPostDTO.getDescription());
         eventRepsitory.save(event);
         return eventMapper.fromEntity(event);
     }).orElseThrow(()->{
         throw new ResourceNotFoundException("Event not found");});
    }
}
