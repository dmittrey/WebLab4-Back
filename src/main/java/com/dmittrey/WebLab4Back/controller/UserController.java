package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.AuthRequest;
import com.dmittrey.WebLab4Back.DTO.response.AuthResponse;
import com.dmittrey.WebLab4Back.service.HitService;
import com.dmittrey.WebLab4Back.service.UserService;
import com.dmittrey.WebLab4Back.service.ValidationResultHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    final ValidationResultHandler validationResultHandler;
    final UserService userService;
    final HitService hitService;

    public UserController(ValidationResultHandler validationResultHandler,
                          UserService userService,
                          HitService hitService) {
        this.validationResultHandler = validationResultHandler;
        this.userService = userService;
        this.hitService = hitService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody AuthRequest loginRequest, BindingResult bindingResult) {

        log.info("User is logging: {}", loginRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Login rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        //Logic...

        return ResponseEntity.ok(new AuthResponse(true));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AuthRequest registerRequest, BindingResult bindingResult) {

        log.info("User is registering: {}", registerRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Register rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        //Logic...

        return ResponseEntity.ok(new AuthResponse(false));
    }
}
