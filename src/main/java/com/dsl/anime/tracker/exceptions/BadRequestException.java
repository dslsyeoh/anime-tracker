package com.dsl.anime.tracker.exceptions;

import com.dsl.anime.tracker.exceptions.dto.Violation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import java.util.*;
import java.util.stream.Collectors;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequestException extends RuntimeException
{
    private List<Violation> errors ;

    public <T> BadRequestException(Set<ConstraintViolation<T>> constraintViolations)
    {
        super();
        errors = constraintViolations.stream().map(constraintViolation -> {
            Violation violation = new Violation();
            violation.setField(constraintViolation.getPropertyPath().toString());
            violation.setErrors(Collections.singletonList(constraintViolation.getMessage()));
            return violation;
        }).collect(Collectors.toList());
    }

    public List<Violation> getErrors()
    {
        return errors;
    }
}
