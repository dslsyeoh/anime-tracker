/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.exceptions.handlers;

import com.dsl.anime.tracker.exceptions.BadRequestException;
import com.dsl.anime.tracker.exceptions.dto.Violation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<List<Violation>> handleBadRequestException(BadRequestException exception)
    {
        List<Violation> violations = exception.getErrors().stream()
                .map(error -> {
                    Violation violation = new Violation();
                    violation.setField(error.getField());
                    violation.setErrors(error.getErrors());
                    return violation;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(violations, HttpStatus.BAD_REQUEST);
    }
}
