/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.dto;

import com.dsl.anime.tracker.constraints.Password;
import com.dsl.anime.tracker.validations.CreateValidation;
import com.dsl.anime.tracker.validations.UpdateValidation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Password(groups = { CreateValidation.class, UpdateValidation.class })
public class User
{
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    @Size(min = 8)
    private String confirmPassword;
}
