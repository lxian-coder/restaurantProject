package com.darcy.restaurantproject.config;

import com.darcy.restaurantproject.auth.ApplicationUserService;
import com.darcy.restaurantproject.jwt.JwtConfig;
import com.darcy.restaurantproject.jwt.JwtTokenFilter;
import com.darcy.restaurantproject.jwt.JwtUsernamePasswordAuthFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.crypto.SecretKey;

/**
 * Darcy Xian  23/7/21  12:15 pm      restaurantProject
 */

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final ApplicationUserService applicationUserService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernamePasswordAuthFilter(authenticationManager(),jwtConfig,secretKey))
                .addFilterAfter(new JwtTokenFilter(secretKey), JwtUsernamePasswordAuthFilter.class)
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/actuator/*","/menu","/event/1").permitAll()
                .anyRequest()
                .authenticated();


    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getPasswordEncoder());
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }



    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return new BCryptPasswordEncoder(10);
    }


    // 解决了 JWT 和 react 配合登录的时候的 CORS问题
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addExposedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//      // set your configuration on the auth object
////     auth.inMemoryAuthentication()
////             .withUser("foo")
////             .password("foo")
////             .roles("USER")
////             .and()
////             .withUser("blah")
////             .password("blah")
////             .roles("ADMIN");
//
//        auth.userDetailsService(applicationUserService);
//
//    }


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
