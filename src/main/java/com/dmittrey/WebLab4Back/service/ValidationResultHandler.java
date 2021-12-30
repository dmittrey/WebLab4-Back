package com.dmittrey.WebLab4Back.service;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class ValidationResultHandler {

    public ResponseEntity<?> handleResult(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        bindingResult
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .forEach(mes -> sb.append(mes).append("!\n"));
        return ResponseEntity.badRequest().body(sb.toString());
    }
}
