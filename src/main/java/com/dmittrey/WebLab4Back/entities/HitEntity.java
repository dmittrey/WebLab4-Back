package com.dmittrey.WebLab4Back.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "HITS")
public class HitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private Double x;
    private Double y;
    private Double r;
    private String currentTime;
    private Double executionTime;
    private Boolean result;

    // Проблема с референсами
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserEntity userEntity;
}
