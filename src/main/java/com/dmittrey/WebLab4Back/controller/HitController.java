package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import com.dmittrey.WebLab4Back.DTO.response.HitResponse;
import com.dmittrey.WebLab4Back.converter.HitFormsConverter;
import com.dmittrey.WebLab4Back.entities.Hit;
import com.dmittrey.WebLab4Back.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/hit")
public class HitController {

    final UserService userService;
    final HitService hitService;
    final HitFormsConverter hitFormsConverter;
    final AreaCheck areaHitChecker;

    public HitController(UserService userService,
                         HitService hitService,
                         HitFormsConverter hitFormsConverter,
                         AreaCheck areaHitChecker) {
        this.userService = userService;
        this.hitService = hitService;
        this.hitFormsConverter = hitFormsConverter;
        this.areaHitChecker = areaHitChecker;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHit(@Valid @RequestBody HitRequest addHitRequest, BindingResult bindingResult) {

        long serviceStartTime = System.nanoTime();

        log.info("Client sent point coordinates: {}!", addHitRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Point add rejected!");
            return ResponseEntity.badRequest().build();
        }

        Hit newHit = hitFormsConverter.convertHitToEntity(addHitRequest);

        newHit.setResult(areaHitChecker.checkHitResult(newHit));

        newHit.setCurrentTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        newHit.setExecutionTime((double) (System.nanoTime() - serviceStartTime) / 100000);

        log.info(newHit.toString());
        /*
        3) Сохранить за юзером
         */

        return ResponseEntity.ok(new HitResponse());
    }

    @PostMapping("/remove_all")
    public ResponseEntity<?> removeAllHits() {

        log.info("Removing all hits!");

        /*
        Удалить все точки закрепленные за определенным юзером
         */

        return ResponseEntity.ok(new HitResponse());
    }

    @PostMapping("/get_all")
    public ResponseEntity<?> getAllHits() {

        log.info("Getting all hits!");

        /*
        Вернуть все точки закрепленные за определенным юзером
         */

        return ResponseEntity.ok(new HitResponse());
    }
}
