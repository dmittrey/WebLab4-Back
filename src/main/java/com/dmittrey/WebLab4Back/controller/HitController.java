package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import com.dmittrey.WebLab4Back.converter.HitFormsConverter;
import com.dmittrey.WebLab4Back.entities.Hit;
import com.dmittrey.WebLab4Back.security.jwt.JwtUser;
import com.dmittrey.WebLab4Back.service.AreaCheck;
import com.dmittrey.WebLab4Back.service.HitService;
import com.dmittrey.WebLab4Back.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.stream.Collectors;

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

        JwtUser user = resolveJwtUser();
        log.info("User id: {}", user.getId());
        hitService.saveHitByUserId(user.getId(), newHit);

        return ResponseEntity.ok().body(Collections.singletonList(hitFormsConverter.convertEntityToPoint(newHit)));
    }

    @PostMapping("/remove_all")
    public ResponseEntity<?> removeAllHits() {

        log.info("Removing all hits!");

        JwtUser user = resolveJwtUser();
        hitService.removeAllHitsByUserId(user.getUsername());

        return ResponseEntity.ok().body("Hi!");
    }

    @PostMapping("/get_all")
    public ResponseEntity<?> getAllHits() {

        log.info("Getting all hits!");

        JwtUser user = resolveJwtUser();

        return ResponseEntity.ok().body(
                hitService.getAllHitsByUserId(user.getUsername())
                        .stream()
                        .map(hitFormsConverter::convertEntityToPoint)
                        .collect(Collectors.toList())
        );
    }

    private JwtUser resolveJwtUser() {
        Authentication authDetails = SecurityContextHolder.getContext().getAuthentication();
        return (JwtUser) authDetails.getPrincipal();
    }
}
