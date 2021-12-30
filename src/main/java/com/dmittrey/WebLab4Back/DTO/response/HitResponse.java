package com.dmittrey.WebLab4Back.DTO.response;

import com.dmittrey.WebLab4Back.DTO.utility.Point;
import lombok.Data;

@Data
public class HitResponse {
    private Point[] data;
}
