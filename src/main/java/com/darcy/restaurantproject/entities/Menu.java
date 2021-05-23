package com.darcy.restaurantproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Darcy Xian  9/5/21  9:35 am      restaurantProject
 */
@Entity
@Getter
@Setter
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private String priceA;
    @Column(name = "priceB")
    private String priceB;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "special", nullable = false)
    private boolean special;


}
