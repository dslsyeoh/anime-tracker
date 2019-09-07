/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.dto;

import com.dsl.anime.tracker.validations.CreateValidation;
import com.dsl.anime.tracker.validations.UpdateValidation;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UserHistory
{
    private Long id;

    @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
    @Min(value = 1, groups = {CreateValidation.class, UpdateValidation.class})
    private int currentEpisode;
}
