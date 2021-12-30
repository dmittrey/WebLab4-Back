package com.dmittrey.WebLab4Back.DTO.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DBCredentials {

    private final String dbUsername;
    private final String dbPassword;
}
