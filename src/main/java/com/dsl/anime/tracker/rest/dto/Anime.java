/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.anime.tracker.rest.dto;

import com.dsl.anime.tracker.constraints.AnimeName;
import com.dsl.anime.tracker.validations.CreateValidation;
import com.dsl.anime.tracker.validations.UpdateValidation;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AnimeName(groups = {CreateValidation.class, UpdateValidation.class})
public class Anime
{
    private Long id;

    @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
    private String name;

    @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
    private Date releaseDate;

    @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
    private Date nextRenewDate;

    @Min(value = 1, groups = {CreateValidation.class, UpdateValidation.class})
    @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
    private int renewDays;

    @Min(value = 1, groups = {CreateValidation.class, UpdateValidation.class})
    @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
    private int currentEpisode;

    @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
    @Min(value = 1, groups = {CreateValidation.class, UpdateValidation.class})
    private int rating;

    private String summary;

    @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
    private boolean onAir;
}
