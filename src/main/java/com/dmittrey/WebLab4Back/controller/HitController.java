package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hit")
public class HitController {

    @GetMapping("/add")
    public ResponseEntity<?> addHit(@RequestBody HitRequest addHitRequest) {
        //Logic...
        return null;
    }

    @GetMapping("/remove_all")
    public ResponseEntity<?> removeAllHits(@RequestBody HitRequest removeAllHitsRequest) {
        //Logic...
        return null;
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAllHits(@RequestBody HitRequest getAllHitsRequest) {
        //Logic...
        return null;
    }
}
