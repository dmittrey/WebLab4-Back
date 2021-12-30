package com.dmittrey.WebLab4Back.config;

import com.dmittrey.WebLab4Back.DTO.utility.DBCredentials;
import com.dmittrey.WebLab4Back.service.EnvVariablesGetter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

public class RepositoryConfig {



//    @Bean
//    @Primary
//    @ConfigurationProperties("spring.datasource")
//    public DataSourceProperties dataSourceProperties() {
////        log.info("Setting login and password for db connection...");
////        DataSourceProperties dsp = new DataSourceProperties();
////        DBCredentials credentials = envVariablesGetter.getDBCredentials("DB_USERNAME",
////                                                                         "DB_PASSWORD");
////        dsp.setUsername(credentials.getDbUsername());
////        dsp.setPassword(credentials.getDbPassword());
//        return
//    }
//
//    @Bean
//    @ConfigurationProperties("app.datasource")
//    public DataSource dataSource(DataSourceProperties properties) {
//        log.info("Getting dataSource from properties...");
//        return properties.initializeDataSourceBuilder().build();
//    }
}
