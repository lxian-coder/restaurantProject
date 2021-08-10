package com.darcy.restaurantproject.controllers;

import com.darcy.restaurantproject.dtos.UserGetDTO;
import com.darcy.restaurantproject.dtos.UserPostDTO;
import com.darcy.restaurantproject.entities.User;
import com.darcy.restaurantproject.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Darcy Xian  5/8/21  10:52 am      restaurantProject
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserGetDTO>> listAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserGetDTO> findUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findUserById((userId)));
    }
    @PostMapping
    public ResponseEntity<UserGetDTO> addNewUser(@RequestBody UserPostDTO newUser){
        log.info(newUser.getEncodedPassword());
        return ResponseEntity.ok(userService.addNewUser(newUser));
    }
    @PatchMapping("/{userId}")
    public ResponseEntity<UserGetDTO> updateUser(@PathVariable Long userId,@RequestBody UserPostDTO userPostDTO){
        return ResponseEntity.ok(userService.updateUser(userId,userPostDTO));
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUserById(userId);
        return;
    }

}
