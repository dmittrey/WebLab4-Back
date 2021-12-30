package com.dmittrey.WebLab4Back.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @Column(updatable = false, nullable = false)
    private String sessionId;

    private String username;
    //todo Закодировать
    private String password;

    // todo Проблема с референсом
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user_id", cascade = CascadeType.ALL)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @Fetch(FetchMode.SELECT)
//    private List<HitEntity> hitList;
}
