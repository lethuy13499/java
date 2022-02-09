package com.jungdo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "provinces")
public class Province implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 20)
    private String name;

    @NotBlank
    @Column(length = 500)
    private String code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
    private Set<District> listDistrict = new HashSet<>();

}

