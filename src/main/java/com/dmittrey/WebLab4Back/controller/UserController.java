package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.AuthRequest;
import com.dmittrey.WebLab4Back.DTO.response.AuthResponse;
import com.dmittrey.WebLab4Back.converter.UserFormsConverter;
import com.dmittrey.WebLab4Back.entities.User;
import com.dmittrey.WebLab4Back.security.jwt.JwtTokenProvider;
import com.dmittrey.WebLab4Back.service.HitService;
import com.dmittrey.WebLab4Back.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;
    final HitService hitService;
    final UserFormsConverter formsConverter;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserService userService,
                          HitService hitService,
                          UserFormsConverter formsConverter,
                          AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.hitService = hitService;
        this.formsConverter = formsConverter;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody AuthRequest loginRequest, BindingResult bindingResult) {

        try {
            log.info("User {} is entering!", loginRequest);

            if (bindingResult.hasErrors()) {
                log.warn("Login rejected!");
                return ResponseEntity.badRequest().body(null);
            }

            String username = loginRequest.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword()));
            Optional<User> user = userService.findByUsername(username);

            if (!user.isPresent()) {
                log.info("Credentials not found in DB!");
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            log.info("User {} entered successfully!", user.get());

            String token = jwtTokenProvider.createToken(user.get());

            return ResponseEntity.ok(
                    new AuthResponse(username, token)
            );
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AuthRequest registerRequest, BindingResult bindingResult) {

        log.info("User {} is registering!", registerRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Register rejected!");
            return ResponseEntity.badRequest().body(null);
        }

        User newUser = formsConverter.convertAuthToEntity(registerRequest);

        if (!userService.checkForSavedStateByUsername(newUser.getUsername())) {
            userService.saveUser(newUser);
            log.info("Registered!");

            String token = jwtTokenProvider.createToken(newUser);

            return ResponseEntity.ok(
                    new AuthResponse(newUser.getUsername(), token)
            );
        } else {
            log.info("Already registered!");
        }

        return ResponseEntity.ok(new AuthResponse());
    }
}
