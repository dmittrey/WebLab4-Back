package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.DAO.HitRepo;
import com.dmittrey.WebLab4Back.DAO.UserRepo;
import com.dmittrey.WebLab4Back.entities.Hit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HitServiceImpl implements HitService {

    private final UserRepo userRepo;
    private final HitRepo hitRepo;

    @Override
    public void saveHitByUserId(Long userId, Hit hit) {

        log.info("Сохраняем попадание");

        userRepo.findById(userId).ifPresent(user -> {
            hit.setUser(user);
            hitRepo.save(hit);
        });

        log.info("Сохранили попадание");
    }

    @Override
    public List<Hit> getAllHitsByUserId(String username) {

        log.info("Возвращаем список");

        return hitRepo.findAllByUserUsername(username);
    }

    @Override
    public void removeAllHitsByUserId(String username) {

        log.info("Начали удалять");

        hitRepo.deleteAllByUserUsername(username);

        log.info("Закончили удалять");
    }
}
