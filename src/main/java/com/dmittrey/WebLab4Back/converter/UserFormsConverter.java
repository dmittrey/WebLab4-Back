package com.dmittrey.WebLab4Back.converter;

import com.dmittrey.WebLab4Back.DTO.request.AuthRequest;
import com.dmittrey.WebLab4Back.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserFormsConverter {

    public User convertAuthToEntity(AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(authRequest.getPassword());
        return user;
    }
}
