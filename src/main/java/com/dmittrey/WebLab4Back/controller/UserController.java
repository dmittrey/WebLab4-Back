package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest loginRequest) {
        //Logic...
        return null;
    }

    @GetMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AuthRequest registerRequest) {
        //Logic...
        return null;
    }
}
