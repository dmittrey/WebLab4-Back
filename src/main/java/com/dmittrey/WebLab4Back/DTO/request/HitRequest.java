package com.dmittrey.WebLab4Back.DTO.request;

import com.dmittrey.WebLab4Back.DTO.utility.Coordinates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HitRequest {
    private Coordinates hitCoordinates;
}
