package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.entities.User;

import java.util.Optional;

public interface UserService {

    void saveUser(User user);

    boolean checkForSavedState(User user);

    Optional<User> findByUsername(String username);
}
