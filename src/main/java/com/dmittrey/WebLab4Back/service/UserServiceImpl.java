package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.DAO.UserRepo;
import com.dmittrey.WebLab4Back.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
