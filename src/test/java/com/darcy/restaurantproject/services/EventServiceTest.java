package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.EventGetDTO;
import com.darcy.restaurantproject.dtos.EventPostDTO;
import com.darcy.restaurantproject.entities.Event;
import com.darcy.restaurantproject.exceptions.ResourceNotFoundException;
import com.darcy.restaurantproject.mappers.EventMapper;
import com.darcy.restaurantproject.repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Darcy Xian  24/5/21  10:10 am      restaurantProject
 */
@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
    Event event = new Event();
    EventPostDTO eventPostDTO = new EventPostDTO();
    @Mock
    private EventRepository eventRepository;
    @Mock
    private EventMapper eventMapper;
    @InjectMocks
    private EventService eventService;
    @BeforeEach
    public void setup (){
        event.setDescription("des");
        event.setTitle("title");

        eventPostDTO.setDescription("postDes");
        eventPostDTO.setTitle("postTitle");
    }
    @Test
    public void shouldUpdateEventSuccessfullyGivenNewEvent(){

         EventGetDTO eventGetDTO = new EventGetDTO();
         eventGetDTO.setDescription("postDes");
         eventGetDTO.setTitle("postTitle");
         when(eventRepository.findById(anyLong())).thenReturn(Optional.of(event));
         when(eventRepository.save(any(Event.class))).thenReturn(event);
          when(eventMapper.fromEntity(any(Event.class))).thenReturn(eventGetDTO);

         EventGetDTO returnedEventGetDTO = eventService.updateEvent(anyLong(),eventPostDTO);
         verify(eventRepository,times(1)).findById(anyLong());
         verify(eventMapper,times(1)).fromEntity(any(Event.class));
        verify(eventRepository,times(1)).save(any(Event.class));
    }
    @Test
    public void shouldThrowExceptionGivenNoEventFindByID(){
        when(eventRepository.findById(anyLong())).thenReturn(Optional.empty());
       assertThrows(ResourceNotFoundException.class,()->eventService.updateEvent(anyLong(),new EventPostDTO()));
    }
    @Test
    public void shouldReturnEventGetDTOSuccessfullyGivenProperID(){
        when(eventRepository.findById(anyLong())).thenReturn(Optional.of(new Event()));
        when(eventMapper.fromEntity(any(Event.class))).thenReturn(new EventGetDTO());

        eventService.findByID(anyLong());
        verify(eventRepository,times(1)).findById(anyLong());
        verify(eventMapper,times(1)).fromEntity(any(Event.class));
    }
}
