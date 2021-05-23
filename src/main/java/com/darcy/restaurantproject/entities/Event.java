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
    @Column(name="ID",nullable = false,unique = true)
    private Long id;
    @Lob
    @Column(name = "picture",nullable = false)
    private Byte[] image;
    @Lob
    @Column(name = "description")
    private String description;

}
