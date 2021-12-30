package com.dmittrey.WebLab4Back.exceptions;

public class NoDBCredentialsEnvVars extends RuntimeException {

    private final String message;

    public NoDBCredentialsEnvVars(String aBadEnvVariableName) {
        message = "Some of DB credentials is empty: " + aBadEnvVariableName;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
