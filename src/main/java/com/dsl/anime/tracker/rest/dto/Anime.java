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

    @NotBlank
    private String name;

    @NotBlank
    private Date releaseDate;

    @NotBlank
    private Date nextRenewDate;

    @Min(1)
    @NotBlank
    private int renewDays;

    @Min(1)
    @NotBlank
    private int currentEpisode;

    @NotBlank
    @Min(1)
    private int rating;
    private String summary;

    @NotBlank
    private boolean onAir;
}
