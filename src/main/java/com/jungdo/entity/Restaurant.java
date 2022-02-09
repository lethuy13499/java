package com.jungdo.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 20)
    private String name;

    @NotBlank
    @Column
    private Integer status;

    @NotBlank
    @Column(length = 500)
    private String address;

    @NotBlank
    @Column(length = 1000)
    private String image;

    @Column
    private Integer vote;

    @Column
    private Integer phone;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Restaurant(Integer status, String address, String image, Integer vote, Integer phone, Category category, Location location) {
        this.status = status;
        this.address = address;
        this.image = image;
        this.vote = vote;
        this.phone = phone;
        this.category = category;
        this.location = location;
    }
}
