package com.darcy.restaurantproject.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Darcy Xian  24/7/21  11:59 am      restaurantProject
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("I am in UserService The Username is "+username);

        return applicationUserDao.fetchUserByUsername(username)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format("Username %s not found",username)));
    }
}
