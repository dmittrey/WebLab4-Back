package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.entities.Hit;

import java.util.List;

public interface HitService {

    Hit saveHit(String userId, Hit hit);

    List<Hit> getAllHitsByUserUsername(String username);

    void removeAllHitsByUserUsername(String userId);
}
