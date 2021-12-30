package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import com.dmittrey.WebLab4Back.DTO.utility.Point;
import com.dmittrey.WebLab4Back.service.ValidationResultHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/hit")
public class HitController {

    final ValidationResultHandler validationResultHandler;

    public HitController(ValidationResultHandler validationResultHandler) {
        this.validationResultHandler = validationResultHandler;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHit(@Valid @RequestBody HitRequest addHitRequest, BindingResult bindingResult) {

        log.info("Client sent point coordinates: {}", addHitRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Point add rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        Point initPoint = new Point();
        initPoint.setHitResult(false);
        initPoint.setCurrentTime(LocalDate.now().toString());
        initPoint.setExecutionTime("0");
        //Logic...

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Point[]{initPoint});
    }

    @PostMapping("/remove_all")
    public ResponseEntity<?> removeAllHits(@RequestBody HitRequest removeAllHitsRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.warn("Removing all points rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        //Logic...

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/get_all")
    public ResponseEntity<?> getAllHits(@RequestBody HitRequest getAllHitsRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.warn("Getting all points rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        //Logic...

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
