package com.darcy.restaurantproject.controllers;

import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.services.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Darcy Xian  9/5/21  6:21 pm      restaurantProject
 */
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    // @RequestBody tell Sping MVC to look at the body of the request and parse it and try to create a
    // MenuPostDTO out of that
    public ResponseEntity<MenuGetDTO> createNewMenuItem(@RequestBody MenuPostDTO menuPostDTO) {
        MenuGetDTO menuGetDTO = menuService.addNewMenuItem(menuPostDTO);
        return ResponseEntity.ok(menuGetDTO);
    }

    @GetMapping
    public ResponseEntity<List<MenuGetDTO>> listAllMenuItem() {
        return ResponseEntity.ok(menuService.listAll());
    }

    @PatchMapping("/{menuItemId}")
    public ResponseEntity<MenuGetDTO> updateMenuItem(@PathVariable Long menuItemId, @RequestBody MenuPostDTO menuPostDTO) {
        return ResponseEntity.ok(menuService.updateMenu(menuItemId, menuPostDTO));
    }

    @DeleteMapping("/{menuItemId}")
    public void deleteMenuItem(@PathVariable Long menuItemId) {
        menuService.deleteMenu(menuItemId);
    }
}
