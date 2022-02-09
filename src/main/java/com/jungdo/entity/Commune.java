package com.jungdo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@Table(name = "communes")
public class Commune implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 20)
    private String name;

    @NotBlank
    @Column(length = 500)
    private String code;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;
}

