package com.jungdo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
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

    @Column
    private Integer vote;

    @Column
    private Integer voucher;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
