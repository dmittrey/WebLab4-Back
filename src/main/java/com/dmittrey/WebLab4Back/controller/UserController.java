package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.AuthRequest;
import com.dmittrey.WebLab4Back.DTO.response.AuthResponse;
import com.dmittrey.WebLab4Back.entities.UserEntity;
import com.dmittrey.WebLab4Back.service.DTOConverter;
import com.dmittrey.WebLab4Back.service.RequestHandler;
import com.dmittrey.WebLab4Back.service.ValidationResultHandler;
import com.dmittrey.WebLab4Back.utility.AuthRequestType;
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
    final DTOConverter dtoConverter;
    final RequestHandler requestHandler;

    public UserController(ValidationResultHandler aValidationResultHandler,
                         DTOConverter aDTOConverter,
                         RequestHandler aRequestHandler) {
        validationResultHandler = aValidationResultHandler;
        dtoConverter = aDTOConverter;
        requestHandler = aRequestHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody AuthRequest loginRequest, BindingResult bindingResult) {

        log.info("User is logging: {}", loginRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Login rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        UserEntity userEntity = dtoConverter.convertAuthToEntity(loginRequest);

        AuthResponse authResponse = requestHandler.processAuthentication(userEntity, AuthRequestType.LOGIN);

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AuthRequest registerRequest, BindingResult bindingResult) {

        log.info("User is registering: {}", registerRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Register rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        UserEntity userEntity = dtoConverter.convertAuthToEntity(registerRequest);

        AuthResponse authResponse = requestHandler.processAuthentication(userEntity, AuthRequestType.REGISTER);

        return ResponseEntity.ok(authResponse);
    }
}
