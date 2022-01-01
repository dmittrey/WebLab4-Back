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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        log.info("In login!");
        try {
            if (bindingResult.hasErrors()) {
                log.warn("Login rejected!");
                return ResponseEntity.badRequest().build();
            }

            String username = loginRequest.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword()));

            Optional<User> user = userService.findByUsername(username);
            log.info("Поискали");

            if (!user.isPresent()) {
                log.info("User not found!");
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            log.info("User is logging: {}", user.get());

            String token = jwtTokenProvider.createToken(user.get());

            AuthResponse response = new AuthResponse();
            response.setUsername(username);
            response.setToken(token);

            log.info("Response: {}", response);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AuthRequest registerRequest, BindingResult bindingResult) {

        log.info("User is registering: {}", registerRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Register rejected!");
            return ResponseEntity.badRequest().build();
        }

        User newUser = formsConverter.convertAuthToEntity(registerRequest);

        if (!userService.checkForSavedState(newUser)) {
            userService.saveUser(newUser);
            log.info("Зарегистрировали!");
            //Отдать токен
        } else {
            log.info("Уже зарегистрирован!");
            //Выкинуть ошибку и обработать
        }

        return ResponseEntity.ok(new AuthResponse());
    }
}
