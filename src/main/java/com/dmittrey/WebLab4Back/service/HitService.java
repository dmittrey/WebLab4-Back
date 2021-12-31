package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.entities.Hit;

import java.util.List;

public interface HitService {

    Hit saveHit(Long userId, Hit hit);

    List<Hit> getAllHitsByUserId(Long userId);

    void removeAllHitsByUserId(Long userId);
}
