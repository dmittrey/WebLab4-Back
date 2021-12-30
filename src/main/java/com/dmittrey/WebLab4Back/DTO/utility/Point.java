package com.dmittrey.WebLab4Back.DTO.utility;

import lombok.*;

@Data
public class Point {
    private boolean hitResult;
    private Coordinates coordinates;
    private String currentTime;
    private String executionTime;
}
