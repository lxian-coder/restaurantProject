package com.darcy.restaurantproject.controllers;

import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.services.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Darcy Xian  23/5/21  1:05 pm      restaurantProject
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(MenuController.class)
public class MenuControllerTest {
    MenuGetDTO menuGetDTO = new MenuGetDTO();
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenuService menuService;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        menuGetDTO.setId(1L);
        menuGetDTO.setSpecial(true);
        menuGetDTO.setDescription("good");
        menuGetDTO.setPrice("12");
        menuGetDTO.setPrice2("22");
        menuGetDTO.setCategory("lunch");
    }
    @Test
    public void testCreateNewMenuItem() throws Exception {

        when(menuService.addNewMenuItem(any(MenuPostDTO.class))).thenReturn(menuGetDTO);
        mockMvc.perform(post("/menu")
               .content(objectMapper.writeValueAsString(menuGetDTO))
               .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.description").value("good"))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.price").value("12"))
                 .andExpect(jsonPath("$.price2").exists())
                 .andExpect(jsonPath("$.price2").value("22"))
               .andExpect(jsonPath("$.category").exists())
               .andExpect(jsonPath("$.category").value("lunch"))
               .andExpect(jsonPath("$.special").exists())
               .andExpect(jsonPath("$.special").value("true"));
    }

    @Test
    public void testFindAllMenu() throws Exception{
        List<MenuGetDTO> menuGetDTOList = new ArrayList<>();
        menuGetDTOList.add(menuGetDTO);
        when(menuService.listAll()).thenReturn(menuGetDTOList);
        mockMvc.perform(get("/menu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]").exists())
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].id").value("1"))
                .andExpect(jsonPath("$.[0].description").exists())
                .andExpect(jsonPath("$.[0].description").value("good"))
                .andExpect(jsonPath("$.[0].price").exists())
                .andExpect(jsonPath("$.[0].price").value("12"))
                .andExpect(jsonPath("$.[0].price2").exists())
                .andExpect(jsonPath("$.[0].price2").value("22"))
                .andExpect(jsonPath("$.[0].category").exists())
                .andExpect(jsonPath("$.[0].category").value("lunch"))
                .andExpect(jsonPath("$.[0].special").exists())
                .andExpect(jsonPath("$.[0].special").value("true"));
    }

    @Test
    public void testPatchMenuByID() throws Exception{

        when(menuService.updateMenu(anyLong(),any(MenuPostDTO.class))).thenReturn(menuGetDTO);
        mockMvc.perform(patch("/menu/1" )
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(menuGetDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.description").value("good"))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.price").value("12"))
                .andExpect(jsonPath("$.price2").exists())
                .andExpect(jsonPath("$.price2").value("22"))
                .andExpect(jsonPath("$.category").exists())
                .andExpect(jsonPath("$.category").value("lunch"))
                .andExpect(jsonPath("$.special").exists())
                .andExpect(jsonPath("$.special").value("true"));;
    }
    @Test
    public void testDeleteMenuItemByID() throws Exception{
        mockMvc.perform(delete("/menu/1")
               .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(menuService,times(1)).deleteMenu(1L);

    }


}
