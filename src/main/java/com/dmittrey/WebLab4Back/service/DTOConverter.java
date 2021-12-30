package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.DTO.request.AuthRequest;
import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import com.dmittrey.WebLab4Back.entities.HitEntity;
import com.dmittrey.WebLab4Back.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class DTOConverter {

    public HitEntity convertHitToEntity(HitRequest hitRequest) {
        HitEntity hitEntity = new HitEntity();
        hitEntity.setX(Double.parseDouble(hitRequest.getXValue()));
        hitEntity.setY(Double.parseDouble(hitRequest.getYValue()));
        hitEntity.setR(Double.parseDouble(hitRequest.getRValue()));
        return hitEntity;
    }

    public HitRequest convertFromHitEntity(HitEntity hitEntity) {
        HitRequest hitRequest = new HitRequest();
        hitRequest.setXValue(hitEntity.getX().toString());
        hitRequest.setYValue(hitEntity.getY().toString());
        hitRequest.setRValue(hitEntity.getR().toString());
        return hitRequest;
    }

    public UserEntity convertAuthToEntity(AuthRequest authRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(authRequest.getUsername());
        userEntity.setPassword(authRequest.getPassword());
        return userEntity;
    }

    public AuthRequest convertFromUserEntity(UserEntity userEntity) {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername(userEntity.getUsername());
        authRequest.setPassword(userEntity.getPassword());
        return authRequest;
    }
}
