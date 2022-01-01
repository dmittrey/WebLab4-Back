package com.dmittrey.WebLab4Back.security.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * Authentication exception
 */
public class JwtAuthenticationException extends AuthenticationException {

    public JwtAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
