package com.dmittrey.WebLab4Back.converter;

import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import com.dmittrey.WebLab4Back.DTO.utility.Coordinates;
import com.dmittrey.WebLab4Back.DTO.utility.Point;
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

    public Point convertEntityToPoint(Hit hitEntity) {
        Point point = new Point();
        point.setHitResult(hitEntity.getResult());
        point.setCoordinates(new Coordinates(hitEntity.getX(), hitEntity.getY(), hitEntity.getR()));
        point.setCurrentTime(hitEntity.getCurrentTime());
        point.setExecutionTime(String.valueOf(hitEntity.getExecutionTime()));
        return point;
    }

}
