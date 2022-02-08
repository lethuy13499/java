package com.jungdo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "status" ,columnDefinition = "int default 1")
    private Integer status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Restaurant> listRestaurant = new HashSet<>();

    public Category() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(String name, String description,Integer status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
