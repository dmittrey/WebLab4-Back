package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.entities.User;

import java.util.Optional;

public interface UserService {

    void saveUser(User user);

    boolean checkForSavedStateByUserId(Long userId);

    boolean checkForSavedStateByUsername(String username);

    Optional<User> findByUserId(Long userId);

    Optional<User> findByUsername(String username);
}
