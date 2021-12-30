package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.DTO.response.AuthResponse;
import com.dmittrey.WebLab4Back.DTO.response.HitResponse;
import com.dmittrey.WebLab4Back.entities.HitEntity;
import com.dmittrey.WebLab4Back.entities.UserEntity;
import com.dmittrey.WebLab4Back.utility.AuthRequestType;
import com.dmittrey.WebLab4Back.utility.HitRequestType;
import org.springframework.stereotype.Service;

@Service
public class RequestHandler {

    public AuthResponse processAuthentication(UserEntity userEntity, AuthRequestType authRequestType) {

    }

    public HitResponse processHit(HitEntity hitEntity, HitRequestType hitRequestType) {

    }

    public HitResponse processHit(HitRequestType hitRequestType) {

    }
}
