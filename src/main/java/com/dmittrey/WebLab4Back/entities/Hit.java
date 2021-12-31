package com.dmittrey.WebLab4Back.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "hit_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hit {

    @Id
    @SequenceGenerator(
            name = "hit_sequence",
            sequenceName = "hit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hit_sequence"
    )
    private Long hitId;

    private Double x;
    private Double y;
    private Double r;
    private String currentTime;
    private Double executionTime;
    private Boolean result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
