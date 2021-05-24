package com.darcy.restaurantproject.controllers;

import com.darcy.restaurantproject.dtos.EventGetDTO;
import com.darcy.restaurantproject.dtos.EventPostDTO;
import com.darcy.restaurantproject.services.EventService;
import com.darcy.restaurantproject.services.MenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Darcy Xian  24/5/21  11:11 am      restaurantProject
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
public class EventControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testUpdateEvent() throws Exception{
        EventGetDTO eventGetDTO = new EventGetDTO();
        eventGetDTO.setDescription("aa");
        eventGetDTO.setId(1L);
        when(eventService.updateEvent(anyLong(),any(EventPostDTO.class))).thenReturn(eventGetDTO);
        mockMvc.perform(patch("/event/1")
                .content(objectMapper.writeValueAsString(eventGetDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.description").value("aa"));
    }



}
