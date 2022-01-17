package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.DAO.UserRepo;
import com.dmittrey.WebLab4Back.entities.Roles;
import com.dmittrey.WebLab4Back.entities.Status;
import com.dmittrey.WebLab4Back.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Roles.USER);
        user.setStatus(Status.ACTIVE);

        userRepo.save(user);
    }

    @Override
    public boolean checkForSavedStateByUserId(Long userId) {

        return userRepo.existsById(userId);
    }

    @Override
    public boolean checkForSavedStateByUsername(String username) {

        return userRepo.existsByUsername(username);
    }

    @Override
    public Optional<User> findByUserId(Long userId) {

        return userRepo.findById(userId);
    }

    @Override
    public Optional<User> findByUsername(String username) {

        return userRepo.findByUsername(username);
    }
}
