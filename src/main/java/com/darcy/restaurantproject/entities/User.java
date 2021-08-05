package com.darcy.restaurantproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Darcy Xian  3/8/21  1:41 pm      restaurantProject
 */
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable = false,nullable = false)
    private Long id;

    @Column(name = "username",unique = true,nullable = false)
    private String username;

    @Column(name="encoded_password",nullable = false)
    private String encodedPassword;

    @Column(name="password_hint")
    private String passwordHint;

    @ManyToMany
    @JoinTable(name="users_authorities",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="authority_id"))
    private Set<Authority> authorities;

}
