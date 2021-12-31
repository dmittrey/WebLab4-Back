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
    public Hit saveHit(Long userId, Hit hit) {
        userRepo.findById(userId).ifPresent(user -> {
            log.info("Ya zdecb");
            hit.setUser(user);
            hitRepo.save(hit);
        });

        return hit;
    }

    @Override
    public List<Hit> getAllHitsByUserId(Long userId) {
        return hitRepo.findAllByUser_UserId(userId);
    }

    @Override
    public void removeAllHitsByUserId(Long userId) {
        hitRepo.deleteAllByUser_UserId(userId);
    }
}
