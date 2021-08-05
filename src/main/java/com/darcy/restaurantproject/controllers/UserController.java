package com.darcy.restaurantproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Darcy Xian  5/8/21  10:52 am      restaurantProject
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {

//    @GetMapping
//    public ResponseEntity<>

}
