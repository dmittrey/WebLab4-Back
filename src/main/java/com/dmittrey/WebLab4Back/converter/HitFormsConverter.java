package com.dmittrey.WebLab4Back.converter;

import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import com.dmittrey.WebLab4Back.entities.Hit;
import org.springframework.stereotype.Service;

@Service
public class HitFormsConverter {

    public Hit convertHitToEntity(HitRequest hitRequest) {
        Hit hit = new Hit();
        hit.setX(Double.parseDouble(hitRequest.getXValue()));
        hit.setY(Double.parseDouble(hitRequest.getYValue()));
        hit.setR(Double.parseDouble(hitRequest.getRValue()));
        return hit;
    }

    public HitRequest convertFromHitEntity(Hit hit) {
        HitRequest hitRequest = new HitRequest();
        hitRequest.setXValue(hit.getX().toString());
        hitRequest.setYValue(hit.getY().toString());
        hitRequest.setRValue(hit.getR().toString());
        return hitRequest;
    }

}
