package com.darcy.restaurantproject.controllers;

import com.darcy.restaurantproject.dtos.MenuGetDTO;
import com.darcy.restaurantproject.dtos.MenuPostDTO;
import com.darcy.restaurantproject.services.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Darcy Xian  9/5/21  6:21 pm      restaurantProject
 */
@CrossOrigin
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
    @PreAuthorize("hasAnyRole('ROLE_BOSS','ROLE_ADMIN')")
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
