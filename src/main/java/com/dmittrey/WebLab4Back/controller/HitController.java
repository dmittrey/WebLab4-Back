package com.dmittrey.WebLab4Back.controller;

import com.dmittrey.WebLab4Back.DTO.request.HitRequest;
import com.dmittrey.WebLab4Back.DTO.response.HitResponse;
import com.dmittrey.WebLab4Back.entities.HitEntity;
import com.dmittrey.WebLab4Back.service.DTOConverter;
import com.dmittrey.WebLab4Back.service.RequestHandler;
import com.dmittrey.WebLab4Back.service.ValidationResultHandler;
import com.dmittrey.WebLab4Back.utility.HitRequestType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/hit")
public class HitController {

    //todo Надо переделать логику и отправлять еще и пользователя

    final ValidationResultHandler validationResultHandler;
    final DTOConverter dtoConverter;
    final RequestHandler requestHandler;

    public HitController(ValidationResultHandler aValidationResultHandler,
                         DTOConverter aDTOConverter,
                         RequestHandler aRequestHandler) {
        validationResultHandler = aValidationResultHandler;
        dtoConverter = aDTOConverter;
        requestHandler = aRequestHandler;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHit(@Valid @RequestBody HitRequest addHitRequest, BindingResult bindingResult) {

        log.info("Client sent point coordinates: {}!", addHitRequest);

        if (bindingResult.hasErrors()) {
            log.warn("Point add rejected!");
            return validationResultHandler.handleResult(bindingResult);
        }

        HitEntity hitEntity = dtoConverter.convertHitToEntity(addHitRequest);

        HitResponse hitResponse = requestHandler.processHit(hitEntity, HitRequestType.ADD);

        return ResponseEntity.ok(hitResponse);
    }

    @PostMapping("/remove_all")
    public ResponseEntity<?> removeAllHits() {

        log.info("Removing all hits!");

        HitEntity hitEntity = new HitEntity();

        HitResponse hitResponse = requestHandler.processHit(HitRequestType.REMOVE_ALL);

        return ResponseEntity.ok(hitResponse);
    }

    @PostMapping("/get_all")
    public ResponseEntity<?> getAllHits() {

        log.info("Getting all hits!");

        HitEntity hitEntity = new HitEntity();

        HitResponse hitResponse = requestHandler.processHit(HitRequestType.ADD);

        return ResponseEntity.ok(hitResponse);
    }
}
