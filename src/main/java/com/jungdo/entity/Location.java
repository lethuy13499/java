package com.jungdo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 200)
    private String coordinates;

    @OneToOne(mappedBy = "location")
    private Restaurant restaurant;


    @NotBlank
    @Column
    private Integer province_id;

    @NotBlank
    @Column
    private Integer commune_id;

    @NotBlank
    @Column
    private String restaurant_name;

    @NotBlank
    @Column
    private Integer district_id;

}