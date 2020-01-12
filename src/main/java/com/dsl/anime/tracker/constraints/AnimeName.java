/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.anime.tracker.constraints;

import com.dsl.anime.tracker.validators.AnimeNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AnimeNameValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnimeName
{
    String message() default "anime.name.existed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
