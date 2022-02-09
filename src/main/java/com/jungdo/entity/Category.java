package com.jungdo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 20)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(name = "status", columnDefinition = "int default 1")
    private Integer status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Restaurant> listRestaurant = new HashSet<>();

    public Category(String name, String description, Integer status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
