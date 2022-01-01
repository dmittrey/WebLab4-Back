package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.entities.Hit;
import org.springframework.stereotype.Service;

@Service
public class AreaHitChecker implements AreaCheck {

    @Override
    public boolean checkHitResult(Hit aHit) {
        return isBlueZone(aHit) || isGreenZone(aHit) || isYellowZone(aHit);
    }

    private boolean isBlueZone(Hit aHit) {
        double x = aHit.getX();
        double y = aHit.getY();
        double r = aHit.getR();

        return (y >= 0) && (x >= 0) && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2));
    }

    private boolean isGreenZone(Hit aHit) {
        double x = aHit.getX();
        double y = aHit.getY();
        double r = aHit.getR();

        return (x >= 0) && (y <= 0) && (x <= r / 2) && (y >= r);
    }

    private boolean isYellowZone(Hit aHit) {
        double x = aHit.getX();
        double y = aHit.getY();
        double r = aHit.getR();

        return (x <= 0) && (y <= 0) && (y >= -x / 2 - r / 2);
    }
}
