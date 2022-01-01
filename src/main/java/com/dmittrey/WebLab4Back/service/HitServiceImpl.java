package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.DAO.HitRepo;
import com.dmittrey.WebLab4Back.DAO.UserRepo;
import com.dmittrey.WebLab4Back.entities.Hit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HitServiceImpl implements HitService{

    private final UserRepo userRepo;
    private final HitRepo hitRepo;

    @Override
    public Hit saveHit(String userId, Hit hit) {
        userRepo.findById(userId).ifPresent(user -> {
            hit.setUser(user);
            hitRepo.save(hit);
        });

        return hit;
    }

    @Override
    public List<Hit> getAllHitsByUserUsername(String username) {
        return hitRepo.findAllByUserUsername(username);
    }

    @Override
    public void removeAllHitsByUserUsername(String username) {
        hitRepo.deleteAllByUserUsername(username);
    }
}
