package com.darcy.restaurantproject.repositories;

import com.darcy.restaurantproject.RestaurantProjectApplication;
import com.darcy.restaurantproject.entities.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

/**
 * Darcy Xian  10/5/21  8:32 am      restaurantProject
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestaurantProjectApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void shouldAddMenuIntoDBSuccessfullyGivenProperMenuObject(){
        Menu menu = new Menu();
        menu.setPrice2("12");
        menu.setCategory("lunch");
        menu.setPrice("22");
        menu.setDescription("good tastes");
        menu.setSpecial(true);
        Menu returnedMenu = menuRepository.save(menu);

        assertEquals("22",menu.getPrice());
        assertEquals("12",menu.getPrice2());
        assertEquals("lunch",menu.getCategory());
        assertEquals("good tastes",menu.getDescription());
        assertTrue(menu.isSpecial());
        assertNotNull(menu.getId());
    }
    @Test
    public void shouldDeleteMenuFromDBSuccessfullyGivenMenuObjectId(){
        Menu menu = new Menu();
        menu.setPrice2("12");
        menu.setCategory("lunch");
        menu.setPrice("22");
        menu.setDescription("good tastes");
        menu.setSpecial(true);
        Menu returnedMenu = menuRepository.save(menu);
        menuRepository.deleteById(returnedMenu.getId());
        Optional<Menu> returnEdMenu2 = menuRepository.findById(returnedMenu.getId());
        assertTrue(!returnEdMenu2.isPresent());
    }
    @Test
    public void shouldReturnAllMenuItemsFromDBSuccessfully(){
        Menu menu = new Menu();
        menu.setPrice2("12");
        menu.setCategory("lunch");
        menu.setPrice("22");
        menu.setDescription("good tastes");
        menu.setSpecial(true);
        menuRepository.save(menu);
        Menu menu2 = new Menu();
        menu2.setPrice2("122");
        menu2.setCategory("lunch");
        menu2.setPrice("22");
        menu2.setDescription("good tastes");
        menu2.setSpecial(true);
        menuRepository.save(menu2);

        List<Menu> menuList = menuRepository.findAll();
        assertEquals(2,menuList.size());
    }
}
