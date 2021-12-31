package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import com.dmittrey.WebLab4Back.DTO.response.HitResponse;
import com.dmittrey.WebLab4Back.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/hit")
public class HitController {
    final ValidationResultHandler validationResultHandler;
    final UserService userService;
    final HitService hitService;

    public HitController(ValidationResultHandler aValidationResultHandler,
                         UserService anUserService,
                         HitService aHitService) {
        validationResultHandler = aValidationResultHandler;
        userService = anUserService;
        hitService = aHitService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHit(@Valid @RequestBody HitRequest addHitRequest, BindingResult bindingResult) {

        log.info("Client sent point coordinates: {}!", addHitRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Point add rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        //Logic...

        return ResponseEntity.ok(new HitResponse());
    }

    @PostMapping("/remove_all")
    public ResponseEntity<?> removeAllHits() {

        log.info("Removing all hits!");

        //Logic...

        return ResponseEntity.ok(new HitResponse());
    }

    @PostMapping("/get_all")
    public ResponseEntity<?> getAllHits() {

        log.info("Getting all hits!");

        //Logic...

        return ResponseEntity.ok(new HitResponse());
    }
}
