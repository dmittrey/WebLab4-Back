package com.dmittrey.WebLab4Back.DTO.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
}
