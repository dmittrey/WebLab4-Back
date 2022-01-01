package com.dmittrey.WebLab4Back.entities;

import lombok.Getter;

public enum Roles {
    USER("User");

    @Getter
    String roleName;

    Roles(String aRoleName) {
        roleName = aRoleName;
    }
}
