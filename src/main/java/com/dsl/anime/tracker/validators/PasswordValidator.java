/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.validators;

import com.dsl.anime.tracker.constraints.Password;
import com.dsl.anime.tracker.rest.dto.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordValidator implements ConstraintValidator<Password, User>
{
    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext)
    {
        return Objects.equals(user.getPassword(), user.getConfirmPassword());
    }
}
