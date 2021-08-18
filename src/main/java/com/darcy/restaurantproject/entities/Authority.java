package com.darcy.restaurantproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Darcy Xian  3/8/21  1:49 pm      restaurantProject
 */
@Getter
@Setter
@Entity(name="authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column(name = "permission", unique = true,nullable = false)
    private String permission;

    @ManyToMany(mappedBy = "authorities")
    @JsonIgnoreProperties(value = "authorities")
    private Set<User> users;
}
