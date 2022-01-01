package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.entities.Hit;

import java.util.List;

public interface HitService {

    void saveHitByUserId(Long userId, Hit hit);

    List<Hit> getAllHitsByUserId(String username);

    void removeAllHitsByUserId(String username);
}
