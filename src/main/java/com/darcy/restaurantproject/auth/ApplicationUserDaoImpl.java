package com.darcy.restaurantproject.auth;

import com.darcy.restaurantproject.entities.Authority;
import com.darcy.restaurantproject.entities.User;
import com.darcy.restaurantproject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Darcy Xian  4/8/21  11:14 pm      restaurantProject
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationUserDaoImpl implements ApplicationUserDao{

    private final UserRepository userRepository;

    @Override
    public Optional<ApplicationUserDetails> fetchUserByUsername(String username) {
       log.info("UserDaoImpl started! UserName is "+username);
        User user = userRepository.findByUsername(username);
        log.info("UserDaoImpl Success!");
        ApplicationUserDetails applicationUserDetails = new ApplicationUserDetails(
                user.getUsername(),
                user.getEncodedPassword(),
                getGrantedAuthorities(user.getAuthorities()),
                true,
                true,
                true,
                true
        );

        return Optional.of(applicationUserDetails);

    }

    private Set<SimpleGrantedAuthority> getGrantedAuthorities(Set<Authority> authorities){
        Set<SimpleGrantedAuthority> permission = authorities.stream()
                .map(authority -> new SimpleGrantedAuthority((authority.getPermission())))
                .collect(Collectors.toSet());
        return permission;
    }
}
