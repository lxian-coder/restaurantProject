package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.entities.Menu;
import com.darcy.restaurantproject.exceptions.ResourceNotFoundException;
import com.darcy.restaurantproject.mappers.MenuMapper;
import com.darcy.restaurantproject.repositories.MenuRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Darcy Xian  10/5/21  10:43 am      restaurantProject
 */
@ExtendWith(MockitoExtension.class)
public class MenuServiceTest {
    private List<MenuGetDTO> mockMenuGTOList =new ArrayList<>();
    private MenuPostDTO menuPostDTO = new MenuPostDTO();

    @Mock
    private MenuRepository menuRepository;
    @Mock
    private MenuMapper menuMapper;
    @InjectMocks
    private MenuService menuService;

    @BeforeEach
    public void setup(){
     MenuGetDTO menuGTO = new MenuGetDTO();
     menuGTO.setId(1L);

     menuGTO.setDescription("good");
     menuGTO.setPrice("12");
     menuGTO.setPrice2("22");
     menuGTO.setCategory("lunch");
     MenuGetDTO menuGetDTO1 = new MenuGetDTO();
     menuGetDTO1.setCategory("dinner");
     menuGetDTO1.setPrice2("11");
     menuGetDTO1.setPrice("19");
     menuGetDTO1.setId(2L);
     menuGetDTO1.setDescription("ok");
     mockMenuGTOList.add(menuGTO);
      mockMenuGTOList.add(menuGetDTO1);

      menuPostDTO.setCategory("post");
      menuPostDTO.setPrice("22");
      menuPostDTO.setPrice2("23");
      menuPostDTO.setDescription("excellent");
    }
    @Test
    public void shouldReturnAllMenus(){
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu());
        menuList.add(new Menu());
        when(menuRepository.findAll()).thenReturn(menuList);
        when(menuMapper.fromEntity(any(Menu.class))).thenReturn(mockMenuGTOList.get(0));
        List<MenuGetDTO> menuGetDTOList = menuService.listAll();
        verify(menuMapper,times(2)).fromEntity(any(Menu.class));
        verify(menuRepository,times(1)).findAll();

        assertEquals(2,menuGetDTOList.size());
        assertEquals(1L,menuGetDTOList.get(0).getId());
        assertEquals("good",menuGetDTOList.get(0).getDescription());
    }
    @Test
    public void shouldAddMenuSuccessfullyGivenProperMenuPost(){
        when(menuRepository.save(any(Menu.class))).thenReturn(new Menu());
        when(menuMapper.fromEntity(any(Menu.class))).thenReturn(mockMenuGTOList.get(0));
        when(menuMapper.toEntity(any(MenuPostDTO.class))).thenReturn(new Menu());
        MenuGetDTO menuGetDTO = menuService.addNewMenuItem(new MenuPostDTO());
        verify(menuMapper,times(1)).fromEntity(any(Menu.class));
        verify(menuMapper,times((1))).toEntity(any(MenuPostDTO.class));
        assertEquals(1,menuGetDTO.getId());
        assertEquals(1L,menuGetDTO.getId());
        assertEquals("good",menuGetDTO.getDescription());
    }
    @Test
    public void shouldUpdateMenuSuccessfullyGivenProperMenuPostAndID(){
        MenuGetDTO getDTOTest = new MenuGetDTO();
        getDTOTest.setCategory("dinner");

        getDTOTest.setPrice2("11");
        getDTOTest.setPrice("19");
        getDTOTest.setId(2L);
        getDTOTest.setDescription("ok");

        Menu menu = new Menu();
        menu.setId(1L);
        menu.setCategory("a");
        menu.setPrice("11");
        menu.setPrice2("12");


     when(menuRepository.findById(anyLong())).thenReturn(java.util.Optional.of(menu));
      when(menuRepository.save(any(Menu.class))).thenReturn(menu);
      when(menuMapper.fromEntity(any(Menu.class))).thenReturn(getDTOTest);
    MenuGetDTO returnedMenuGetDTO = menuService.updateMenu( anyLong(), menuPostDTO);

    verify(menuRepository,times(1)).findById(anyLong());
    verify(menuRepository,times(1)).save(any(Menu.class));
    verify(menuMapper,times(1)).fromEntity(any(Menu.class));
    }

    @Test
    public void shouldThrowExceptionGivenNoMenuFindByID(){
        when(menuRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, ()->{menuService.updateMenu(anyLong(),new MenuPostDTO());});
    }
}
















