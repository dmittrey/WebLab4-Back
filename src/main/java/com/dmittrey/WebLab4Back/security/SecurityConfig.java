package com.dmittrey.WebLab4Back.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // enable CORS support
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        // httpBasic - let you enable/disable http basic authentication
        http.httpBasic().disable();
        // disable cross site request forgery
        http.csrf().disable();
    }
}
