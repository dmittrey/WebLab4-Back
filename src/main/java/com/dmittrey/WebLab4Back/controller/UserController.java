package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.AuthRequest;
import com.dmittrey.WebLab4Back.DTO.response.AuthResponse;
import com.dmittrey.WebLab4Back.service.ValidationResultHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    final ValidationResultHandler validationResultHandler;

    public UserController(ValidationResultHandler validationResultHandler) {
        this.validationResultHandler = validationResultHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody AuthRequest loginRequest, BindingResult bindingResult) {

        log.info("User is logging: {}", loginRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Login rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }


        //Logic...
        //2) Сервис обработки main-logic
        //3) Respository
        //4) Прикрутить security постфактум

        return new ResponseEntity<>(new AuthResponse(true), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AuthRequest registerRequest, BindingResult bindingResult) {

        log.info("User is registering: {}", registerRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Register rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        //Logic...

        return new ResponseEntity<>(new AuthResponse(true), HttpStatus.OK);
    }
}
