package com.darcy.restaurantproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Darcy Xian  9/5/21  4:58 pm      restaurantProject
 */
@Entity
@Getter
@Setter
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name = "picture")
    private Byte[] image;

    @Column(name = "description")
    private String description;

}
