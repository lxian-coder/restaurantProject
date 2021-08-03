package com.darcy.restaurantproject.config;

import com.darcy.restaurantproject.auth.ApplicationUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Darcy Xian  23/7/21  12:15 pm      restaurantProject
 */
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final ApplicationUserService applicationUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      // set your configuration on the auth object
//     auth.inMemoryAuthentication()
//             .withUser("foo")
//             .password("foo")
//             .roles("USER")
//             .and()
//             .withUser("blah")
//             .password("blah")
//             .roles("ADMIN");

        auth.userDetailsService(applicationUserService);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//
//            //    .antMatchers("/menu/**").hasRole("ADMIN")
//                .antMatchers("/menu").hasRole("USER")
//                .antMatchers("/").permitAll()
//                .and().formLogin();
//    }
}
