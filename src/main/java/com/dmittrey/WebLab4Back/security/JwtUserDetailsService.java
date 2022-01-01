package com.dmittrey.WebLab4Back.security;

import com.dmittrey.WebLab4Back.entities.User;
import com.dmittrey.WebLab4Back.security.jwt.JwtUser;
import com.dmittrey.WebLab4Back.security.jwt.JwtUserFactory;
import com.dmittrey.WebLab4Back.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService} interface
 * for {@link com.dmittrey.WebLab4Back.security.jwt.JwtUser}.
 */
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findByUsername(username);

        if (user.isPresent()) {
            JwtUser jwtUser = JwtUserFactory.create(user.get());
            log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
            return jwtUser;
        } else
            throw new UsernameNotFoundException("User with username: " + username + " not found");
    }
}
