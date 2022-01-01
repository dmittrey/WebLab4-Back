package com.dmittrey.WebLab4Back.DTO.response;

import com.dmittrey.WebLab4Back.DTO.utility.Point;
import lombok.Data;

import java.util.List;

@Data
public class HitResponse {
    private List<Point> data;
}
