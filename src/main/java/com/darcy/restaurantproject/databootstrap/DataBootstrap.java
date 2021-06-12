package com.darcy.restaurantproject.databootstrap;

import com.darcy.restaurantproject.entities.Event;
import com.darcy.restaurantproject.entities.Menu;
import com.darcy.restaurantproject.repositories.EventRepository;
import com.darcy.restaurantproject.repositories.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  24/5/21  10:14 pm      restaurantProject
 */

