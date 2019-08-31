package com.dsl.anime.tracker.constraints;

import com.dsl.anime.tracker.validators.AnimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AnimeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Anime
{
    String message() default "testing";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
