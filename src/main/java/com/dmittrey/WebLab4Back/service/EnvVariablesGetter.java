package com.dmittrey.WebLab4Back.service;

import com.dmittrey.WebLab4Back.DTO.utility.DBCredentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EnvVariablesGetter {

    public DBCredentials getDBCredentials(String dbUsernameVarName, String dbPasswordVarName) {
        String dbUsername = System.getenv(dbUsernameVarName);
        String dbPassword = System.getenv(dbPasswordVarName);

//        if (dbUsername.isEmpty()) throw new NoDBCredentialsEnvVars(dbUsernameVarName);
//        if (dbPassword.isEmpty()) throw new NoDBCredentialsEnvVars(dbUsernameVarName);

        return new DBCredentials(dbUsername, dbPassword);
    }
}
